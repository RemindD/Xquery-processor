import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Utils;
import org.antlr.v4.runtime.tree.*;
import org.w3c.dom.*;
import java.util.*;
import java.io.*;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XPath_Runner{
    public static String evaluate(String query) throws Exception {

        // Init ANTLR
        ANTLRInputStream inputStream = new ANTLRInputStream(query);
        XQueryLexer lexer = new XQueryLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokenStream);
        //ParseTree tree = parser.ap();
        ParseTree tree = parser.query();

        // Visit
        EvalVistor visitor = new EvalVistor();
        ArrayList<Node> res = visitor.visit(tree);
        System.out.println(res.size());
        // Build result String
        StringBuilder resStr = new StringBuilder();
        for (Node node : res) {
            if (node == null) continue;
            String str;
            System.out.println(node.getNodeType());

            if (node.getNodeType() != 2) {
                str = nodeToString(node);
                resStr.append(str.substring(str.indexOf("?>") + 2));
                resStr.append('\n');

            }
            if (node.getNodeType() == 2) {
                str = node.getTextContent();

                resStr.append(node.getNodeName()+"=\""+str+"\"");
                resStr.append('\n');
            }
        }
        return resStr.toString().trim();
    }

    private static String nodeToString(Node node) throws Exception {
        StringWriter writer = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(new DOMSource(node), new StreamResult(writer));
        return writer.toString();
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Please indicate input and output file path.");
            return;
        }
        String input = args[0];
        String output = args[1];

        // Read single query from file
        File queryFile = new File(input);
        byte[] queryBuf = new byte[4096];
        (new FileInputStream(queryFile)).read(queryBuf);
        String query = (new String(queryBuf)).trim();
        System.out.println("---------Query--------\n" + query);

        String myRes = evaluate(query);

        File resultFile = new File(output);
        FileOutputStream outputStream = new FileOutputStream(resultFile);
        outputStream.write(myRes.getBytes());

    }
}
