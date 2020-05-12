import jdd.bdd.BDD;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {

   private List<NodesCollection> nodesCollection = new ArrayList<>();
   private List<Node> nodes = new ArrayList<>();
   private Node nodeTemp;

    public void createNodes(int numberOfNodes) {
        for (int i = 0; i < numberOfNodes; i++)
            nodes.add(new Node(i + 1));
    }


    public void createNodesCollection(String expression1, int numberOfNodes) {
        for (int k = numberOfNodes + 2; k < expression1.length() - numberOfNodes; k = k + numberOfNodes + 2)
            this.nodesCollection.add(new NodesCollection(expression1.substring(k, k + numberOfNodes)));
    }


    public void addNodes() {
        for (int j = 0; j < nodesCollection.size(); j++) {
            for (int i = 0; i < nodesCollection.get(j).stringOfExpression.length(); i++) {
                if (nodesCollection.get(j).stringOfExpression.charAt(i) != '0') {
                    nodesCollection.get(j).nodes.add(nodes.get(i));
                    //System.out.println("Tworze wierzcholek numer " + (i + 1) + "\n");
                }
            }
        }
    }

    public void colorNodes(int kolor) {
        for (int i = 0; i < nodesCollection.size(); i++) {
            Collections.sort(nodesCollection, (d1, d2) -> {
                return d2.nodes.size() - d1.nodes.size();
            });
            for (int j = 0; nodesCollection.get(0).nodes.size() != 0; ) {
                nodeTemp=nodesCollection.get(j).nodes.get(j);
                System.out.println(nodeTemp.getNameOfNode() + "  kolor  " + kolor + "\n");
                nodes.get(nodes.indexOf(nodeTemp)).setColour(kolor);
                for (int k = 0; k < nodesCollection.size(); k++) {
                  //  System.out.println("Usuwam " +a +" z  " +"\n");
                    nodesCollection.get(k).nodes.remove(nodeTemp);
                }
            }
            kolor = kolor + 1;
        }
    }

    public String expressionScanner(BDD bdd, int xfinal) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        bdd.printSet(xfinal);
        System.out.flush();
        System.setOut(old);
        return baos.toString();
    }


}