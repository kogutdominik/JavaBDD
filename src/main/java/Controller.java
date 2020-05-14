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
    private String bddExpression;
    private int color = 0;

    public void createNodes(int numberOfNodes) {
        for (int i = 0; i < numberOfNodes; i++)
            nodes.add(new Node(i + 1));
    }

    public void createNodesCollection(int numberOfNodes) {
        for (int k = numberOfNodes + 2; k < bddExpression.length() - numberOfNodes; k = k + numberOfNodes + 2)
            this.nodesCollection.add(new NodesCollection(bddExpression.substring(k, k + numberOfNodes)));
    }

    public void addNodes() {
        for (int j = 0; j < nodesCollection.size(); j++) {
            for (int i = 0; i < nodesCollection.get(j).stringOfExpression.length(); i++) {
                if (nodesCollection.get(j).stringOfExpression.charAt(i) != '0') {
                    nodesCollection.get(j).nodes.add(nodes.get(i));
                }
            }
        }
    }

    public void colorNodes() {
        for (int i = 0; i < nodesCollection.size(); i++) {
            Collections.sort(nodesCollection, (d1, d2) -> {
                return d2.nodes.size() - d1.nodes.size();
            });
            if (nodesCollection.get(0).nodes.size() != 0)
                color = color + 1;
            for (int j = 0; nodesCollection.get(0).nodes.size() != 0; ) {
                nodeTemp = nodesCollection.get(j).nodes.get(j);
                nodes.get(nodes.indexOf(nodeTemp)).setColour(color);
                for (int k = 0; k < nodesCollection.size(); k++) {
                    nodesCollection.get(k).nodes.remove(nodeTemp);
                }
            }
        }

        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getColour() == 0)
                nodes.get(i).setColour(color + 1);
        }
        System.out.println("\n Ilosc kolorow to: " + (color + 1));
    }

    public void expressionScanner(BDD bdd, int xfinal) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        bdd.printSet(xfinal);
        System.out.flush();
        System.setOut(old);
        bddExpression = baos.toString();
    }

    public void printColor() {
        for (int i = 0; i < nodes.size(); i++)
            System.out.println(nodes.get(i).toString());
    }
}