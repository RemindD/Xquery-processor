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

        System.out.println("------Original Query------");
        System.out.println(query);

        /* Try to rewrite */
        String res = rewrite(query);

        System.out.println("------Rewritten Query-----");
        System.out.println(res);

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
            String var2 = ctx.path(i).varname() == null ? null
                    :ctx.path(i).varname().getText();
            tree.addVar(var, var2, path);
        }

        for (int i=0; i<ctx.cond().varname().size(); i++) {
            if (ctx.cond().varorsentence(i).varname() != null) {
                // Not self const condition
                String var1 = ctx.cond().varname(i).getText();
                String var2 = ctx.cond().varorsentence(i).varname().getText();
                tree.addJoin(var1, var2);
            } else {
                // Self const condition
                String var = ctx.cond().varname(i).getText();
                String constant = ctx.cond().varorsentence(i).sentence().getText();
                tree.addSelfCond(var, constant);
            }
        }
        String joinExpression = tree.mergeAllJoinNode();

        /* Replace variables in return */
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

    private TreeNode rootNode;

    private HashMap<String, TreeNode> variableMap;

    private ArrayList<JoinNode> joinNodes;

    public VariableTree() {
        rootNode = new TreeNode();
        variableMap = new HashMap<String, TreeNode>();
        joinNodes = new ArrayList<JoinNode>();
        variableMap.put("rootNode", rootNode);
    }

    public void addVar(String var, String var2, String path) {
        if (variableMap.containsKey(var)) {
            throw new IllegalStateException("for has duplicate vars.");
        }

        // Get the parent node
        TreeNode pnode = (var2 == null) ? rootNode : variableMap.get(var2);
        if (pnode == null) {
            throw new IllegalStateException();
        }

        // Attach the new node under the parent node
        TreeNode node = new TreeNode();
        node.parent = pnode;
        node.relativePath = path;
        node.var = var;
        pnode.children.add(node);
        variableMap.put(var, node);

        // Assign this node to one Join Node
        assignJoinNum(node);
    }

    /**
     * Add one join condition between join nodes
     * @param var1  var name of node 1 to join
     * @param var2  var name of node 2 to join
     */
    public void addJoin(String var1, String var2) {
        TreeNode node1 = variableMap.get(var1);
        TreeNode node2 = variableMap.get(var2);
        if (node1 == null || node2 == null) {
            throw new IllegalStateException();
        }

        JoinNode joinNode1 = joinNodes.get(node1.joinNum);
        JoinNode joinNode2 = joinNodes.get(node2.joinNum);

        JoinNode.OuterCond(joinNode1, node1, joinNode2, node2);
    }

    /**
     * Add one self condition to one one join node
     * @param var   var name of the condition
     * @param constant  const condition
     */
    public void addSelfCond(String var, String constant) {
        TreeNode node = variableMap.get(var);
        if (node == null) {
            throw new IllegalStateException();
        }

        JoinNode joinNode = joinNodes.get(node.joinNum);
        joinNode.InnerCond(node, constant);
    }

    /**
     * Assign one node to its join node
     * @param node  node to assign
     * @return  join number
     */
    public int assignJoinNum(TreeNode node) {
        if (node.joinNum == -1) {

            ArrayList<TreeNode> path = new ArrayList<TreeNode>();
            TreeNode currentNode = node;

            /* Go upwards, until find one assigned node or reach the rootNode*/
            while (currentNode != rootNode && currentNode.joinNum == -1) {
                path.add(0, currentNode);
                currentNode = currentNode.parent;
            }

            if (currentNode != rootNode) {
                /* If find one assigned node, then assign to the same node */
                for (TreeNode n : path) {
                    JoinNode joinNode = joinNodes.get(currentNode.joinNum);
                    joinNode.varSet.add(n);
                    n.joinNum = currentNode.joinNum;
                }
            } else {
                /* If reach the rootNode, then create a new join node and assign */
                int num = joinNodes.size();
                JoinNode joinNode = new JoinNode(num);
                joinNodes.add(joinNode);
                for (TreeNode n : path) {
                    joinNode.varSet.add(n);
                    n.joinNum = num;
                }
            }
        }
        return node.joinNum;
    }

    /**
     * Merge all join nodes in the join node list
     * @return  Merged expression
     */
    public String mergeAllJoinNode() {
        while (joinNodes.size() != 1) {
            JoinNode node1 = joinNodes.remove(0);
            JoinNode node12 = null;
            if (node1.joinTable.keySet().size() != 0) {
                node12 = node1.joinTable.keySet().iterator().next();
            /*JoinNode node2 = */
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

    /**
     * Merge two join nodes and return the merged one
     * @param n1    join node 1
     * @param n2    join node 2
     * @return      new merged node
     */
    public JoinNode mergeJoinNode(JoinNode n1, JoinNode n2) {

        /* Remove each other from the join table */
        Map<TreeNode, TreeNode> joinMap = n1.joinTable.remove(n2);
        n2.joinTable.remove(n1);

        /* Add other join conditions to the new node's join map */
        JoinNode newNode = new JoinNode(n1.joinNum);
        for (JoinNode n : n1.joinTable.keySet()) {
            if (newNode.joinTable.containsKey(n)) {
                newNode.joinTable.get(n).putAll(n1.joinTable.get(n));
            } else {
                newNode.joinTable.put(n, n1.joinTable.get(n));
            }
        }
        for (JoinNode n : n2.joinTable.keySet()) {
            if (newNode.joinTable.containsKey(n)) {
                newNode.joinTable.get(n).putAll(n2.joinTable.get(n));
            } else {
                newNode.joinTable.put(n, n2.joinTable.get(n));
            }
        }
        for (JoinNode n : joinNodes) {
            Map<TreeNode, TreeNode> mapToN1 = n.joinTable.remove(n1);
            Map<TreeNode, TreeNode> mapToN2 = n.joinTable.remove(n2);
            if (mapToN1 != null) n.joinTable.put(newNode, mapToN1);
            if (mapToN2 != null) n.joinTable.put(newNode, mapToN2);
        }

        /* Construct the join expression */
        StringBuilder res = new StringBuilder();
        res.append("join(\n");
        res.append(n1.getExpression());
        res.append(",\n");
        res.append(n2.getExpression());
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
        res.append("VariableTree:\n");
        for (TreeNode n : variableMap.values()) {
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
    public ArrayList<TreeNode> children;
    public int joinNum;

    public TreeNode() {
        children = new ArrayList<TreeNode>();
        joinNum = -1;
    }
}

class JoinNode {

    public int joinNum;
    public ArrayList<TreeNode> varSet;
    public HashMap<JoinNode, Map<TreeNode, TreeNode>> joinTable;
    public HashMap<TreeNode, String> selfCondMap;
    public HashMap<TreeNode, TreeNode> selfJoinMap;
    public String expression;

    public JoinNode(int joinNum) {
        this.joinNum = joinNum;
        varSet = new ArrayList<TreeNode>();
        joinTable = new HashMap<JoinNode, Map<TreeNode, TreeNode>>();
        selfCondMap = new HashMap<TreeNode, String>();
        selfJoinMap = new HashMap<TreeNode, TreeNode>();
    }

    /**
     * Get experssion for one single join node
     * @return  string of the expression
     */
    public String getExpression() {
        if (expression == null) {
            StringBuilder exp = new StringBuilder();
            exp.append("for\n");
            for (TreeNode n : varSet) {
                exp.append("\t" + n.var + " in " + n.relativePath + ",\n");
            }
            exp.deleteCharAt(exp.length()-2);
            if (selfCondMap.size() != 0 || selfJoinMap.size() != 0) {
                exp.append("where\n");
                for (TreeNode n : selfCondMap.keySet()) {
                    exp.append("\t"+n.var+" eq "+selfCondMap.get(n)+",\n");
                }
                for (TreeNode n : selfJoinMap.keySet()) {
                    exp.append("\t"+n.var+" eq "+selfJoinMap.get(n).var+",\n");
                }
                exp.deleteCharAt(exp.length()-2);
            }
            exp.append("return\n<tuple>{\n");
            for (TreeNode n : varSet) {
                exp.append("\t<"+n.var.substring(1)+">{" +n.var +"}</"
                        +n.var.substring(1)+">,\n");
            }
            exp.deleteCharAt(exp.length()-2);
            exp.append("}</tuple>\n");

            expression = exp.toString();
        }
        return expression;
    }

    public void InnerCond(TreeNode n, String constant) {
        selfCondMap.put(n, constant);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("#########\n");
        res.append("JoinNode:" + joinNum + "\n");
        res.append("var list:\n");
        for (TreeNode n : varSet) {
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
        for (TreeNode n : selfCondMap.keySet()) {
            res.append(n.var+" -|> "+ selfCondMap.get(n) +"\n");
        }
        return res.toString();
    }

    public static void OuterCond(JoinNode n1, TreeNode v1, JoinNode n2, TreeNode v2) {

        if (n1 == n2) {
            n1.selfJoinMap.put(v1, v2);
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