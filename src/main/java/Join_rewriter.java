/**
 * Created by richard on 3/7/17.
 */

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class Join_rewriter {
    public static String rewrite(String query) {

        // Init ANTLR
        ANTLRInputStream inputStream = new ANTLRInputStream(query);
        JoinLexer lexer = new JoinLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        JoinParser parser = new JoinParser(tokenStream);
        ParseTree tree = parser.query();

        // Visit
        Join_visiter visitor = new Join_visiter();
        String res = (String) visitor.visit(tree);

        /* If the query don't need to be rewrite, retuen it self */
        if (res == null) res = query;

        return res;
    }

    public static void main(String[] args) throws Exception{

        if (args.length != 2) {
            System.out.println("Please indicates input and output path");
            return;
        }
        String input = args[0];
        String output = args[1];

        /* read query from file */
        File queryFile = new File(input);
        byte[] queryBuf = new byte[4096*2];
        (new FileInputStream(queryFile)).read(queryBuf);
        String query = (new String(queryBuf)).trim();

        /* Try to rewrite */
        String res = rewrite(query);

        /* Write result back to the file */
        File resultFile = new File(output);
        FileOutputStream outputStream = new FileOutputStream(resultFile);
        outputStream.write(res.getBytes());
    }
}


class Join_visiter extends JoinBaseVisitor<Object> {

    public VariableTree tree = new VariableTree();

    @Override
    public String visitQuery(JoinParser.QueryContext ctx) {
        if (ctx.cond() == null) return null;

        for (int i=0; i<ctx.varname().size(); i++) {
            String var = ctx.varname(i).getText();
            String path = ctx.path(i).getText();
            String var2;
            if (ctx.path(i).varname() == null) {
                var2 = null;
            }
            else {
                var2 = ctx.path(i).varname().getText();
            }
            tree.addVar(var, var2, path);
        }

        for (int i=0; i<ctx.cond().varname().size(); i++) {
            if (ctx.cond().varorsentence(i).varname() != null) {
                String var1 = ctx.cond().varname(i).getText();
                String var2 = ctx.cond().varorsentence(i).varname().getText();
                tree.addJoin(var1, var2);
            } else {
                String var = ctx.cond().varname(i).getText();
                String constant = ctx.cond().varorsentence(i).sentence().getText();
                tree.addSelfCond(var, constant);
            }
        }
        String joinExpression = tree.mergeAllJoinNode();

        String retExpression = ctx.ret().getText().replace("$", "$tuple/");
        StringBuilder builder = new StringBuilder(retExpression);
        /* Add star after each variable in the tuple */
        for (int i=builder.indexOf("$tuple/"), j=i+7; i != -1;
             i=builder.indexOf("$tuple/", j+2)) {
            for (j=i+7; j<builder.length(); j++) {
                char ch = builder.charAt(j);
                if (ch == ',' || ch == '}' || ch == '/') {
                    break;
                }
            }
            builder.insert(j, "/*");
        }
        retExpression = builder.toString();

        return "for $tuple in " + joinExpression + "\nreturn " + retExpression;
    }
}

class VariableTree {

    private TreeNode root;

    private HashMap<String, TreeNode> varMap;

    private ArrayList<JoinNode> joinNodes;

    public VariableTree() {
        root = new TreeNode();
        varMap = new HashMap<String, TreeNode>();
        joinNodes = new ArrayList<JoinNode>();
        varMap.put("root", root);
    }

    public void addVar(String var, String var2, String path) {
        if (varMap.containsKey(var)) {
            throw new IllegalStateException("for has duplicate vars.");
        }

        // Get the parent node
        TreeNode pnode = (var2 == null) ? root : varMap.get(var2);
        if (pnode == null) {
            throw new IllegalStateException();
        }

        // Attach the new node under the parent node
        TreeNode node = new TreeNode();
        node.parent = pnode;
        node.relativePath = path;
        node.var = var;
        pnode.children.add(node);
        varMap.put(var, node);

        // Assign this node to one Join Node
        assignJoinNum(node);
    }

    public void addJoin(String var1, String var2) {
        TreeNode node1 = varMap.get(var1);
        TreeNode node2 = varMap.get(var2);
        if (node1 == null || node2 == null) {
            throw new IllegalStateException();
        }

        JoinNode joinNode1 = joinNodes.get(node1.joinNum);
        JoinNode joinNode2 = joinNodes.get(node2.joinNum);

        JoinNode.addJoin(joinNode1, node1, joinNode2, node2);
    }

    public void addSelfCond(String var, String constant) {
        TreeNode node = varMap.get(var);
        if (node == null) {
            throw new IllegalStateException();
        }

        JoinNode joinNode = joinNodes.get(node.joinNum);
        joinNode.addSelfCond(node, constant);
    }

    public int assignJoinNum(TreeNode node) {
        if (node.joinNum == -1) {

            LinkedList<TreeNode> path = new LinkedList<TreeNode>();
            TreeNode currNode = node;

            /* Go upwards, until find one assigned node or reach the root*/
            while (currNode != root && currNode.joinNum == -1) {
                path.add(0, currNode);
                currNode = currNode.parent;
            }

            if (currNode != root) {
                /* If find one assigned node, then assign to the same node */
                for (TreeNode n : path) {
                    JoinNode joinNode = joinNodes.get(currNode.joinNum);
                    joinNode.variableSet.add(n);
                    n.joinNum = currNode.joinNum;
                }
            } else {
                /* If reach the root, then create a new join node and assign */
                int num = joinNodes.size();
                JoinNode joinNode = new JoinNode(num);
                joinNodes.add(joinNode);
                for (TreeNode n : path) {
                    joinNode.variableSet.add(n);
                    n.joinNum = num;
                }
            }
        }
        return node.joinNum;
    }

    public String mergeAllJoinNode() {
        while (joinNodes.size() != 1) {
            JoinNode node1 = joinNodes.remove(0);
            JoinNode node12 = null;
            if (node1.joinTable.keySet().size() != 0) {
                node12 = node1.joinTable.keySet().iterator().next();
                if (!joinNodes.remove(node12)) {
                    throw new IllegalStateException();
                }
            } else {
                node12 = joinNodes.remove(0);
            }
            JoinNode newNode = mergeJoinNode(node1, node12);
            joinNodes.add(0, newNode);
        }
        return joinNodes.get(0).getExpression();
    }

    public JoinNode mergeJoinNode(JoinNode node1, JoinNode node2) {

        /* Remove each other from the join table */
        Map<TreeNode, TreeNode> joinMap = node1.joinTable.remove(node2);
        node2.joinTable.remove(node1);

        /* Add other join conditions to the new node's join map */
        JoinNode newNode = new JoinNode(node1.joinNum);
        for (JoinNode node : node1.joinTable.keySet()) {
            if (newNode.joinTable.containsKey(node)) {
                newNode.joinTable.get(node).putAll(node1.joinTable.get(node));
            } else {
                newNode.joinTable.put(node, node1.joinTable.get(node));
            }
        }
        for (JoinNode n : node2.joinTable.keySet()) {
            if (newNode.joinTable.containsKey(n)) {
                newNode.joinTable.get(n).putAll(node2.joinTable.get(n));
            } else {
                newNode.joinTable.put(n, node2.joinTable.get(n));
            }
        }
        for (JoinNode node : joinNodes) {
            Map<TreeNode, TreeNode> mapToN1 = node.joinTable.remove(node1);
            Map<TreeNode, TreeNode> mapToN2 = node.joinTable.remove(node2);

            if (mapToN1 != null) node.joinTable.put(newNode, mapToN1);
            if (mapToN2 != null) node.joinTable.put(newNode, mapToN2);
        }

        /* Construct the join expression */
        StringBuilder res = new StringBuilder();
        res.append("join(\n");
        res.append(node1.getExpression());
        res.append(",\n");
        res.append(node2.getExpression());
        res.append(",\n");

        /* Construct the join cond list expression */
        res.append("[");
        if (joinMap != null) {
            for (TreeNode n : joinMap.keySet()) {
                res.append(n.var.substring(1) + ", ");
            }
            res.deleteCharAt(res.length() - 1);
            res.deleteCharAt(res.length() - 1);
        }
        res.append("],\n");

        res.append("[");
        if (joinMap != null) {
            for (TreeNode n : joinMap.keySet()) {
                res.append(joinMap.get(n).var.substring(1) + ", ");
            }
            res.deleteCharAt(res.length() - 1);
            res.deleteCharAt(res.length() - 1);
        }
        res.append("]");
        res.append(")\n");

        newNode.expression = res.toString();

        return newNode;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LabelTree:\n");
        for (TreeNode n : varMap.values()) {
            res.append("\n" + n.var + " | " + n.relativePath + "\n");
            res.append("children: \n");
            for (TreeNode c : n.children) {
                res.append(c.var + " | " + c.relativePath + "\n");
            }
        }
        res.append("JoinNodes:\n");
        for (JoinNode n : joinNodes) {
            res.append(n);
            res.append(n.getExpression());
        }
        return res.toString();
    }
}

class TreeNode {

    public String var;
    public String relativePath;
    public TreeNode parent;
    public LinkedList<TreeNode> children;
    public int joinNum;

    public TreeNode() {
        children = new LinkedList<TreeNode>();
        joinNum = -1;
    }
}

class JoinNode {

    public int joinNum;
    public LinkedList<TreeNode> variableSet;
    public Map<JoinNode, Map<TreeNode, TreeNode>> joinTable;
    public Map<TreeNode, String> InnerCondMap;
    public Map<TreeNode, TreeNode> InnerJoinMap;
    public String expression;

    public JoinNode(int joinNum) {
        this.joinNum = joinNum;
        variableSet = new LinkedList<TreeNode>();
        joinTable = new HashMap<JoinNode, Map<TreeNode, TreeNode>>();
        InnerCondMap = new HashMap<TreeNode, String>();
        InnerJoinMap = new HashMap<TreeNode, TreeNode>();
    }

    public String getExpression() {
        if (expression == null) {
            StringBuilder exp = new StringBuilder();
            exp.append("for\n");
            for (TreeNode n : variableSet) {
                exp.append("\t" + n.var + " in " + n.relativePath + ",\n");
            }
            exp.deleteCharAt(exp.length()-2);
            if (InnerCondMap.size() != 0 || InnerJoinMap.size() != 0) {
                exp.append("where\n");
                for (TreeNode n : InnerCondMap.keySet()) {
                    exp.append("\t"+n.var+" eq "+ InnerCondMap.get(n)+",\n");
                }
                for (TreeNode n : InnerJoinMap.keySet()) {
                    exp.append("\t"+n.var+" eq "+ InnerJoinMap.get(n).var+",\n");
                }
                exp.deleteCharAt(exp.length()-2);
            }
            exp.append("return\n<tuple>{\n");
            for (TreeNode n : variableSet) {
                exp.append("\t<"+n.var.substring(1)+">{" +n.var +"}</"
                        +n.var.substring(1)+">,\n");
            }
            exp.deleteCharAt(exp.length()-2);
            exp.append("}</tuple>\n");

            expression = exp.toString();
        }
        return expression;
    }

    public void addSelfCond(TreeNode n, String constant) {
        InnerCondMap.put(n, constant);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("#########\n");
        res.append("JoinNode:" + joinNum + "\n");
        res.append("var list:\n");
        for (TreeNode n : variableSet) {
            res.append(n.var + " | " + n.relativePath + "\n");
        }
        res.append("Join cond:\n");
        for (JoinNode n : joinTable.keySet()) {
            res.append(n.joinNum + ": \n");
            for (TreeNode ln : joinTable.get(n).keySet()) {
                res.append(ln.var+" <|> "+joinTable.get(n).get(ln).var+"\n");
            }
        }
        res.append("Self Cond:\n");
        for (TreeNode n : InnerCondMap.keySet()) {
            res.append(n.var+" -|> "+ InnerCondMap.get(n) +"\n");
        }
        return res.toString();
    }

    public static void addJoin(JoinNode n1, TreeNode v1, JoinNode n2, TreeNode v2) {

        if (n1 == n2) {
            n1.InnerJoinMap.put(v1, v2);
        } else {
            if (!n1.joinTable.containsKey(n2)) {
                n1.joinTable.put(n2, new HashMap<TreeNode, TreeNode>());
            }
            n1.joinTable.get(n2).put(v1, v2);

            if (!n2.joinTable.containsKey(n1)) {
                n2.joinTable.put(n1, new HashMap<TreeNode, TreeNode>());
            }
            n2.joinTable.get(n1).put(v2, v1);
        }
    }
}
