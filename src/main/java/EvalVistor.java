import org.w3c.dom.*;
import java.util.*;
import org.antlr.v4.runtime.tree.*;
import javax.xml.parsers.*;
import java.io.*;
import org.antlr.v4.runtime.*;

public class EvalVistor extends XQueryBaseVisitor<ArrayList<Node>> {

    private Stack<ArrayList<Node>> stack = new Stack<ArrayList<Node>>();
    private Document tree;

    private ArrayList<Node> visitNode(ArrayList<Node> current_Node, RuleNode ruleNode) {
        stack.push(current_Node);
        ArrayList<Node> res = visit(ruleNode);
        stack.pop();
        return res;
    }

    private ArrayList<Node> visit_descendent_or_self(ArrayList<Node> current_Node, RuleNode ruleNode) {
        HashSet<Node> result = new HashSet<Node>();
        if (current_Node.size() == 0) return new ArrayList<Node>(result);

        for (Node node : current_Node) {
            ArrayList<Node> temp = new ArrayList<Node>();
            temp.add(node);
            ArrayList<Node> children = new ArrayList<Node>();
            NodeList childrenlist = node.getChildNodes();
            for (int i=0; i<childrenlist.getLength(); ++i)
                children.add(childrenlist.item(i));

            ArrayList<Node> rpSlashRp = visitNode(temp, ruleNode);
            ArrayList<Node> rpSlashSlashRp = visit_descendent_or_self(children, ruleNode);
            result.addAll(rpSlashRp);
            result.addAll(rpSlashSlashRp);

            //System.out.println("rpSlashRp: " + rpSlashRp.size());
            //System.out.println("rpSlashSlashRp: " + rpSlashSlashRp.size());
        }

        return new ArrayList<Node>(result);
    }

    @Override
    public ArrayList<Node> visitApslash(XQueryParser.ApslashContext ctx) {
        String filename = ctx.file().getText();
        File xmlFile = new File(filename);
        Document currDoc = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            currDoc = builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Open file error.");
        }

        ArrayList<Node> root = new ArrayList<Node>();
        root.add(currDoc.getDocumentElement().getParentNode());
        stack.push(root);
        return visitNode(root, ctx.rp());
    }

    @Override
    public ArrayList<Node> visitApdoubleslash(XQueryParser.ApdoubleslashContext ctx) {
        String fileName = ctx.file().getText();
        fileName = fileName.substring(1, fileName.length()-1); // delete quotes
        File xmlFile = new File(fileName);
        Document currDoc = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            currDoc = builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Open file error.");
        }

        ArrayList<Node> root = new ArrayList<Node>();
        root.add(currDoc.getDocumentElement().getParentNode());
        stack.push(root);
        return visit_descendent_or_self(root, ctx.rp());
    }

    @Override
    public ArrayList<Node> visitRpparen(XQueryParser.RpparenContext ctx) {
        return visitNode(stack.peek(), ctx.rp());
    }

    public ArrayList<Node> visitRpself(XQueryParser.RpselfContext ctx) {
        return stack.peek();
    }

    public ArrayList<Node> visitRpparent(XQueryParser.RpparentContext ctx){
        ArrayList<Node> current_Node = stack.peek();
        ArrayList<Node> result=new ArrayList<Node>();

        for (int i=0; i<current_Node.size(); ++i) {
            result.add(current_Node.get(i).getParentNode());
        }

        // need unique
        return result;

    }

    @Override
    public ArrayList<Node> visitRptext(XQueryParser.RptextContext ctx){
        ArrayList<Node> result = new ArrayList<Node>();

        for (Node node : stack.peek()) {
            result.add(node.getFirstChild());
        }

        return result;
    }
    @Override
    public ArrayList<Node> visitRpslash(XQueryParser.RpslashContext ctx) {
        ArrayList<Node> res1 = visitNode(stack.peek(), ctx.rp(0));
        ArrayList<Node> res2 = visitNode(res1, ctx.rp(1));
        return res2;
    }
    @Override
    public ArrayList<Node> visitRpdoubleslash(XQueryParser.RpdoubleslashContext ctx) {
        ArrayList<Node> res1 = visitNode(stack.peek(), ctx.rp(0));
        ArrayList<Node> res = visit_descendent_or_self(res1, ctx.rp(1));
        return res;
    }
    @Override
    public ArrayList<Node> visitRpchild(XQueryParser.RpchildContext ctx) {
        ArrayList<Node> result = new ArrayList<Node>();
        ArrayList<Node> current_Node = stack.peek();
        for (int i=0; i<current_Node.size(); ++i) {
            NodeList children = current_Node.get(i).getChildNodes();
            for (int j=0; j<children.getLength(); ++j) {
                result.add(children.item(j));
            }
        }

        return result;
    }
    @Override
    public ArrayList<Node> visitRptag(XQueryParser.RptagContext ctx) {
        String tagName = ctx.string().getText();

        ArrayList<Node> current_Node = stack.peek();
        ArrayList<Node> result = new ArrayList<Node>();
        for (int i=0; i<current_Node.size(); ++i) {
            NodeList children = current_Node.get(i).getChildNodes();
            for (int j=0; j<children.getLength(); ++j) {
                Node node = children.item(j);
                if (node.getNodeName().equals(tagName))
                    result.add(node);
            }
        }

        return result;
    }
    @Override
    public ArrayList<Node> visitRpcancat(XQueryParser.RpcancatContext ctx) {
        ArrayList<Node> res1 = visitNode(stack.peek(), ctx.rp(0));
        ArrayList<Node> res2 = visitNode(stack.peek(), ctx.rp(1));

        // TODO: not sure about the addall function
        res1.addAll(res2);
        return res1;
    }

    @Override
    public ArrayList<Node> visitRpfilter(XQueryParser.RpfilterContext ctx) {
        ArrayList<Node> res1 = visitNode(stack.peek(), ctx.rp());
        ArrayList<Node> result = visitNode(res1, ctx.f());

        return result;
    }

    @Override
    public ArrayList<Node> visitRpattr(XQueryParser.RpattrContext ctx){

        ArrayList<Node> result = new ArrayList<Node>();
        String attName = ctx.string().getText();
        for(Node node : stack.peek()) {
            if(node.hasAttributes()) {
                Node att = node.getAttributes().getNamedItem(attName);
                if (att != null) result.add(att);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Node> visitFltor(XQueryParser.FltorContext ctx) {
        ArrayList<Node> current_Node = stack.peek();
        HashSet<Node> result = new HashSet<Node>();
        ArrayList<Node> res1 = new ArrayList<Node>();
        ArrayList<Node> res2 = new ArrayList<Node>();
        for (Node node : stack.peek()) {
            ArrayList<Node> temp = new ArrayList<Node>();
            temp.add(node);
            if (!visitNode(temp, ctx.f(0)).isEmpty()) {
                res1.add(node);
            }
            if (!visitNode(temp, ctx.f(1)).isEmpty()) {
                res2.add(node);
            }

        }
        result.addAll(res1);
        result.addAll(res2);
        return new ArrayList<Node>(result);
    }

    private boolean valueContains(ArrayList<Node> nodelist, Node node) {
        for (Node n : nodelist) {
            if (n.isEqualNode(node)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Node> visitFltnot(XQueryParser.FltnotContext ctx) {
        ArrayList<Node> notres = new ArrayList<Node>();
        ArrayList<Node> res = new ArrayList<Node>();
        for (Node node : stack.peek()) {
            ArrayList<Node> temp = new ArrayList<Node>();
            temp.add(node);
            if (!visitNode(temp, ctx.f()).isEmpty()) {
                notres.add(node);
            }
        }

        for (Node node : stack.peek()) {
            if (!valueContains(notres, node))
                res.add(node);
        }
        return res;
    }

    private boolean idContains(ArrayList<Node> nodelist, Node node) {
        for (Node n : nodelist) {
            if (n.isSameNode(node)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Node> visitFltrpeq(XQueryParser.FltrpeqContext ctx){
        ArrayList<Node> res = new ArrayList<Node>();
        for(Node node : stack.peek()) {
            ArrayList<Node> tmpContext = new ArrayList<Node>();
            tmpContext.add(node);
            ArrayList<Node> res1 = visitNode(tmpContext, ctx.rp(0));
            ArrayList<Node> res2 = visitNode(tmpContext, ctx.rp(1));
            for (Node temp : res1) {
                if (idContains(res2, temp)) {
                    res.add(node);
                    break;
                }
            }
        }
        return res;
    }

    //empty function
    @Override
    public ArrayList<Node> visitFltrpvaleq(XQueryParser.FltrpvaleqContext ctx){
        ArrayList<Node> res = new ArrayList<Node>();
        for(Node node : stack.peek()) {
            ArrayList<Node> tmpContext = new ArrayList<Node>();
            tmpContext.add(node);
            ArrayList<Node> res1 = visitNode(tmpContext, ctx.rp(0));
            ArrayList<Node> res2 = visitNode(tmpContext, ctx.rp(1));
            for (Node temp : res1) {
                if (valueContains(res2, temp)) {
                    res.add(node);
                    break;
                }
            }
        }
        return res;
    }

    @Override
    public ArrayList<Node> visitFltrp(XQueryParser.FltrpContext ctx) {
        ArrayList<Node> result = new ArrayList<Node>();
        for (Node node : stack.peek()) {
            ArrayList<Node> tmp = new ArrayList<Node>();
            tmp.add(node);
            if (!visitNode(tmp, ctx.rp()).isEmpty()) {
                result.add(node);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Node> visitFltparen(XQueryParser.FltparenContext ctx) {
        ArrayList<Node> res = visitNode(stack.peek(), ctx.f());
        return res;
    }

    @Override
    public ArrayList<Node> visitFltand(XQueryParser.FltandContext ctx) {
        ArrayList<Node> current_Node = stack.peek();
        HashSet<Node> result = new HashSet<Node>();
        ArrayList<Node> res1 = new ArrayList<Node>();
        ArrayList<Node> res2 = new ArrayList<Node>();
        for (Node node : stack.peek()) {
            ArrayList<Node> temp = new ArrayList<Node>();
            temp.add(node);
            if (!visitNode(temp, ctx.f(0)).isEmpty()) {
                res1.add(node);
            }
            if (!visitNode(temp, ctx.f(1)).isEmpty()) {
                res2.add(node);
            }
        }
        for (Node node : res1) {
            if (result.contains(node))
                result.add(node);
        }

        return new ArrayList<Node>(result);
    }

}