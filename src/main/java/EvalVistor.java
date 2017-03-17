import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import org.antlr.v4.runtime.tree.RuleNode;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;
import java.util.*;

public class EvalVistor extends XQueryBaseVisitor<ArrayList<Node>> {

    private Stack<ArrayList<Node>> stack = new Stack<ArrayList<Node>>();
    private LinkedList<HashMap<String, ArrayList<Node>>> variableList = new LinkedList<HashMap<String, ArrayList<Node>>>();
    private Document tree = new DocumentImpl();
    public TransformerFactory transformerFactory;
    EvalVistor() {
        stack.push(new ArrayList<Node>());
    }

    private ArrayList<Node> visitNode(ArrayList<Node> current_Node, RuleNode ruleNode) {
        stack.push(current_Node);
        ArrayList<Node> res = visit(ruleNode);
        stack.pop();
        return res;
    }
    

    private ArrayList<Node> visit_descendent_or_self(ArrayList<Node> current_Node, RuleNode ruleNode) {
        ArrayList<Node> result = new ArrayList<Node>();
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
            for (Node node2 : rpSlashSlashRp) {
                if (!idContains(result, node2))
                    result.add(node2);
            }
        }

        return result;
    }

    private boolean valueContains(ArrayList<Node> nodelist, Node node) {
        for (Node n : nodelist) {
            if (n.isEqualNode(node)) {
                return true;
            }
        }
        return false;
    }

    private boolean idContains(ArrayList<Node> nodelist, Node node) {
        for (Node n : nodelist) {
            if (n.isSameNode(node)) {
                return true;
            }
        }
        return false;
    }

    /*
        visit rule for xquery
     */

    @Override
    public ArrayList<Node> visitXqap(XQueryParser.XqapContext ctx) {
        return visitNode(stack.peek(), ctx.ap());
    }

    @Override
    public ArrayList<Node> visitXqtag(XQueryParser.XqtagContext ctx) {
        Node resultNode = tree.createElement(ctx.string(0).getText());
        ArrayList<Node> Nodelist = visitNode(stack.peek(), ctx.query());
        for (Node node: Nodelist) {
            Node childnode = resultNode.getOwnerDocument().importNode(node, true);
            resultNode.appendChild(childnode);
        }
        ArrayList<Node> result = new ArrayList<Node>();
        result.add(resultNode);
        return result;
    }

    @Override
    public ArrayList<Node> visitXqvar(XQueryParser.XqvarContext ctx) {
        ArrayList<Node> result = new ArrayList<Node>();
        for (Map<String, ArrayList<Node>> temp: variableList) {
            if (temp.containsKey(ctx.varname().getText())) {
                result = temp.get(ctx.varname().getText());
                break;
            }
        }
        return result;
    }

    @Override
    public ArrayList<Node> visitXqconcat(XQueryParser.XqconcatContext ctx) {
        ArrayList<Node> res1 = visitNode(stack.peek(), ctx.query(0));
        ArrayList<Node> res2 = visitNode(stack.peek(), ctx.query(1));

        ArrayList<Node> result = new ArrayList<Node>();
        result.addAll(res1);
        for (Node node : res2) {

            if (!idContains(result, node))
                result.add(node);
            //result.add(node);
        }
        return result;
    }


    @Override
    public ArrayList<Node> visitXqslash(XQueryParser.XqslashContext ctx) {
        ArrayList<Node> temp = visitNode(stack.peek(), ctx.query());
        return visitNode(temp, ctx.rp());
    }

    @Override
    public ArrayList<Node> visitXqdoubleslash(XQueryParser.XqdoubleslashContext ctx) {
        ArrayList<Node> temp = visitNode(stack.peek(), ctx.query());
        return visit_descendent_or_self(temp, ctx.rp());
    }



    @Override
    public ArrayList<Node> visitXqparen(XQueryParser.XqparenContext ctx) {
        return visitNode(stack.peek(), ctx.query());
    }

    @Override
    public ArrayList<Node> visitXqstring(XQueryParser.XqstringContext ctx) {
        ArrayList<Node> result = new ArrayList<Node>();
        String str = ctx.sentence().getText();
        result.add(tree.createTextNode(str.substring(1, str.length()-1)));
        return result;
    }

    @Override
    public ArrayList<Node> visitFlwr(XQueryParser.FlwrContext ctx) {
        ArrayList<Node> res = new ArrayList<Node>();
        String varName = ctx.varname().getText();
        ArrayList<Node> varList = visitNode(stack.peek(), ctx.query());

        for (Node v : varList) {
            variableList.addFirst(new HashMap<String, ArrayList<Node>>());
            ArrayList<Node> tmpContext = new ArrayList<Node>();
            tmpContext.add(v);
            variableList.peek().put(varName, tmpContext);
            if (ctx.lwr() != null) {
                ArrayList<Node> temp = visitNode(stack.peek(), ctx.lwr());
                for (Node node: temp) {
                    if (!idContains(res, node))
                        res.add(node);
                }
            } else {
                ArrayList<Node> temp = visitNode(stack.peek(), ctx.flwr());
                for (Node node: temp) {
                    if (!idContains(res, node))
                        res.add(node);
                }
            }
            variableList.removeFirst();
        }

        return res;

    }

    @Override public ArrayList<Node> visitLwr(XQueryParser.LwrContext ctx){
        if (ctx.letClause() != null) { visitNode(stack.peek(), ctx.letClause()); }
        if (ctx.whereClause() != null) {
            if (visitNode(stack.peek(), ctx.whereClause()) == null) {
                return new ArrayList<Node>();
            }
        }
        return visitNode(stack.peek(), ctx.returnClause());
    }

    @Override
    public ArrayList<Node> visitXqlet(XQueryParser.XqletContext ctx) {
        variableList.addFirst(new HashMap<String, ArrayList<Node>>());
        visitNode(stack.peek(), ctx.letClause());
        ArrayList<Node> result = visitNode(stack.peek(), ctx.query());
        variableList.removeFirst();

        return result;
    }

    @Override
    public ArrayList<Node> visitLetClause(XQueryParser.LetClauseContext ctx) {
        for (int i=0; i<ctx.query().size(); i++) {
            ArrayList<Node> varValue = visitNode(stack.peek(), ctx.query(i));
            variableList.peek().put(ctx.varname(i).getText(), varValue);
        }
        return null;
    }

    @Override
    public ArrayList<Node> visitWhereClause(XQueryParser.WhereClauseContext ctx) {
        return visitNode(stack.peek(), ctx.cond());
    }

    @Override
    public ArrayList<Node> visitReturnClause(XQueryParser.ReturnClauseContext ctx) {
        return visitNode(stack.peek(), ctx.query());
    }

    /*
        visit rule for condition
     */
    @Override
    public ArrayList<Node> visitCondeq(XQueryParser.CondeqContext ctx) {
        ArrayList<Node> res1 = visitNode(stack.peek(), ctx.query(0));
        ArrayList<Node> res2 = visitNode(stack.peek(), ctx.query(1));
        for (Node node: res1) {
            if (node == null)
                continue;
            if (idContains(res2, node)) {
                return new ArrayList<Node>();
            }
        }
        return null;
    }

    @Override
    public ArrayList<Node> visitCondvaleq(XQueryParser.CondvaleqContext ctx) {
        ArrayList<Node> res1 = visitNode(stack.peek(), ctx.query(0));
        ArrayList<Node> res2 = visitNode(stack.peek(), ctx.query(1));
        for (Node node: res1) {
            if (node == null)
                continue;
            if (valueContains(res2, node)) {
                return new ArrayList<Node>();
            }
        }
        return null;
    }

    @Override
    public ArrayList<Node> visitCondnot(XQueryParser.CondnotContext ctx) {
        ArrayList<Node> result = visitNode(stack.peek(), ctx.cond());
        if (result == null)
            return new ArrayList<Node>();
        else
            return null;
    }

    @Override
    public ArrayList<Node> visitCondempty(XQueryParser.CondemptyContext ctx) {
        ArrayList<Node> result = visitNode(stack.peek(), ctx.query());
        if (result.isEmpty())
            return new ArrayList<Node>();
        else
            return null;
    }

    @Override
    public ArrayList<Node> visitCondexist(XQueryParser.CondexistContext ctx) {
        return visitNode(stack.peek(), ctx.somecond());
    }

    @Override
    public ArrayList<Node> visitSomecond(XQueryParser.SomecondContext ctx) {
        String varName = ctx.varname().getText();
        ArrayList<Node> varList = visitNode(stack.peek(), ctx.query());

        for (Node v : varList) {
            variableList.addFirst(new HashMap<String, ArrayList<Node>>());
            ArrayList<Node> tmpContext = new ArrayList<Node>();
            tmpContext.add(v);
            variableList.peek().put(varName, tmpContext);
            if (ctx.somecond() != null) {
                ArrayList<Node> temp = visitNode(stack.peek(), ctx.somecond());
                if (temp != null)
                    return new ArrayList<Node>();

            } else {
                ArrayList<Node> temp = visitNode(stack.peek(), ctx.cond());
                if (temp != null)
                    return new ArrayList<Node>();
            }
            variableList.removeFirst();
        }
        return null;
    }

    @Override
    public ArrayList<Node> visitCondand(XQueryParser.CondandContext ctx) {
        ArrayList<Node> res1 = visitNode(stack.peek(), ctx.cond(0));
        ArrayList<Node> res2 = visitNode(stack.peek(), ctx.cond(1));
        if (res1 != null && res2 != null)
            return new ArrayList<Node>();
        else
            return null;
    }

    @Override
    public ArrayList<Node> visitCondor(XQueryParser.CondorContext ctx) {
        ArrayList<Node> res1 = visitNode(stack.peek(), ctx.cond(0));
        ArrayList<Node> res2 = visitNode(stack.peek(), ctx.cond(1));
        if (res1 != null || res2 != null)
            return new ArrayList<Node>();
        else
            return null;
    }

    @Override
    public ArrayList<Node> visitCondparen(XQueryParser.CondparenContext ctx) {
        return visitNode(stack.peek(), ctx.cond());
    }

    /*
        visit rule for xpath
     */
    @Override
    public ArrayList<Node> visitApslash(XQueryParser.ApslashContext ctx) {
        String fileName = ctx.sentence().getText();
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
        return visitNode(root, ctx.rp());
    }

    @Override
    public ArrayList<Node> visitApdoubleslash(XQueryParser.ApdoubleslashContext ctx) {
        String fileName = ctx.sentence().getText();
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
        for (Node temp :current_Node) {
            if (temp == null) continue;
            Node node;
            if (temp.getNodeType() == 2)
                node = ((Attr)temp).getOwnerElement();
            else
                node = temp.getParentNode();
            // need unique
            if (!idContains(result, node))
                result.add(node);
        }


        return result;

    }

    @Override
    public ArrayList<Node> visitRptext(XQueryParser.RptextContext ctx){
        ArrayList<Node> result = new ArrayList<Node>();

        for (Node node : stack.peek()) {
            if (node.getNodeType() != 3)
                result.add(node.getFirstChild());
        }

        return result;
    }
    @Override
    public ArrayList<Node> visitRpslash(XQueryParser.RpslashContext ctx) {
        ArrayList<Node> res1 = visitNode(stack.peek(), ctx.rp(0));
        return visitNode(res1, ctx.rp(1));
    }
    @Override
    public ArrayList<Node> visitRpdoubleslash(XQueryParser.RpdoubleslashContext ctx) {
        ArrayList<Node> res1 = visitNode(stack.peek(), ctx.rp(0));
        return visit_descendent_or_self(res1, ctx.rp(1));
    }
    @Override
    public ArrayList<Node> visitRpchild(XQueryParser.RpchildContext ctx) {
        

        ArrayList<Node> result = new ArrayList<Node>();
        ArrayList<Node> current_Node = stack.peek();
        for (Node node: current_Node) {
            NodeList children = node.getChildNodes();
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
        for (Node temp : current_Node) {
            NodeList children = temp.getChildNodes();
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

        res1.addAll(res2);
        return res1;
    }

    @Override
    public ArrayList<Node> visitRpfilter(XQueryParser.RpfilterContext ctx) {
        ArrayList<Node> res1 = visitNode(stack.peek(), ctx.rp());
        return visitNode(res1, ctx.f());
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
        for (Node node : res2) {
            if (!idContains(res1, node))
                res1.add(node);
        }
        return res1;
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
        return visitNode(stack.peek(), ctx.f());
    }

    @Override
    public ArrayList<Node> visitFltand(XQueryParser.FltandContext ctx) {
        ArrayList<Node> current_Node = stack.peek();
        ArrayList<Node> result = new ArrayList<Node>();
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
            if (res2.contains(node))
                result.add(node);
        }
        return result;
    }

    @Override
    public ArrayList<Node> visitXqJoin(XQueryParser.XqJoinContext ctx){
        ArrayList<Node> result = new ArrayList<Node>();
        ArrayList<Node> query1 = visit(ctx.joinClause().query(0));
        int attrLen = ctx.joinClause().attrPairs(0).string().size();
        ArrayList<Map<String, ArrayList<Node>>> mapStringToNode = new ArrayList<Map<String, ArrayList<Node>>>();

        for(int i = 0; i < attrLen; i++){
            Map<String, ArrayList<Node>> map = new HashMap<String, ArrayList<Node>>();
            String name1 = ctx.joinClause().attrPairs(0).string(i).getText();

            ArrayList<Node> nodeList;
            for(Node n : query1){
                String keyRaw = nodeToString(((Element) n).getElementsByTagName(name1).item(0));
                String key = keyRaw.substring(name1.length() + 2, keyRaw.length() - name1.length() - 3);
                if(!map.containsKey(key)) {
                    nodeList = new ArrayList<Node>();
                    nodeList.add(n.cloneNode(true));
                    map.put(key, nodeList);
                }
                else {
                    nodeList = map.get(key);
                    nodeList.add(n.cloneNode(true));
                    map.put(key, nodeList);
                }
            }
            mapStringToNode.add(map);
        }

        ArrayList<Node> query2 = visit(ctx.joinClause().query(1));
        ArrayList<Node> joinList = new ArrayList<Node>();
        for(Node n: query2){
            for(int j = 0; j < attrLen; j++){
                String name2 = ctx.joinClause().attrPairs(1).string(j).getText();
                String keyRaw2 = nodeToString(((Element) n).getElementsByTagName(name2).item(0));
                String key2 = keyRaw2.substring(name2.length() + 2, keyRaw2.length() - name2.length() - 3);
                if(mapStringToNode.get(j).containsKey(key2)){
                    if(joinList.isEmpty()) joinList.addAll(mapStringToNode.get(j).get(key2));
                    else{
                        ArrayList<Node> filterList = new ArrayList<Node>();
                        ArrayList<Node> next = mapStringToNode.get(j).get(key2);
                        HashSet<String> compareStr = new HashSet<String>();
                        for(Node t : joinList) compareStr.add(nodeToString(t));
                        for(Node m : next){
                            if(compareStr.contains(nodeToString(m))){
                                filterList.add(m.cloneNode(true));
                            }
                        }
                        joinList = filterList;
                        //if (joinList.isEmpty()) break;
                    }
                }
                else {
                    joinList.clear();
                    break;
                }
            }
            if(!joinList.isEmpty()){
                int len = n.getChildNodes().getLength();
                Node temp;
                for(Node p : joinList){
                    Node newNode = p.cloneNode(true);
                    for(int w = 0; w < len; w++){
                        temp = n.getChildNodes().item(w).cloneNode(true);
                        newNode.appendChild(temp);

                    }
                    result.add(newNode);
                }
                // for (Node n1: joinList) result.add(mergeTuple(n, n1));
                joinList.clear();
            }

        }
        return result;
    }

    private Node mergeTuple(Node tuple1, Node tuple2) {

        Node joinedNode = tree.createElement("tuple");
        NodeList nl1 = tuple1.getChildNodes();
        NodeList nl2 = tuple2.getChildNodes();
        for (int j=0; j<nl1.getLength(); j++) {
            Node iNode = tree.importNode(nl1.item(j), true);
            joinedNode.appendChild(iNode);
        }
        for (int j=0; j<nl2.getLength(); j++) {
            Node iNode = tree.importNode(nl2.item(j), true);
            joinedNode.appendChild(iNode);
        }

        return joinedNode;
    }

    private String nodeToString(Node n){
        this.transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        StringWriter w = new StringWriter();
        try{
            transformer = this.transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            DOMSource s = new DOMSource(n);
            transformer.transform(s, new StreamResult(w));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch(TransformerException e){
            e.printStackTrace();
        }
        return w.toString();

    }










}