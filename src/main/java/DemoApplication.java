import java.io.IOException;

public class DemoApplication {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        BDDController bddController = new BDDController();
        int xfinal = bddController.readDataFromFile("graf.txt");
        int numberOfNodes = bddController.getNumberOfNodes();
        Controller controller = new Controller();

        controller.expressionScanner(bddController.getBdd(), xfinal);
        controller.createNodes(numberOfNodes);
        controller.createNodesCollection(numberOfNodes);
        controller.addNodes();
        controller.colorNodes();
        controller.printColor();

        //bddController.bdd.printSet(xfinal);
        long stop = System.currentTimeMillis();
        System.out.println("Czas wykonania (w nanosekundach): " + (stop - start));
    }
}