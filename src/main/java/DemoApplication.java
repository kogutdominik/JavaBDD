
import jdd.bdd.BDD;

import java.io.IOException;


public class DemoApplication {


    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        int kolor = 1;

        BDD bdd = new BDD(10000, 1000);
        int numberOfNodes = 6;
        int v1 = bdd.createVar();
        int v2 = bdd.createVar();
        int v3 = bdd.createVar();
        int v4 = bdd.createVar();
        int v5 = bdd.createVar();
        int v6 = bdd.createVar();


        int x1 = bdd.ref(bdd.and(v1, v2));
        int x2 = bdd.ref(bdd.and(v1, v4));
        int x3 = bdd.ref(bdd.and(v1, v6));
        int x4 = bdd.ref(bdd.and(v2, v3));
        int x5 = bdd.ref(bdd.and(v2, v5));
        int x6 = bdd.ref(bdd.and(v2, v6));
        int x7 = bdd.ref(bdd.and(v3, v5));
        int x8 = bdd.ref(bdd.and(v5, v6));

        int xfinal = bdd.ref(bdd.or(x1, x2));
        xfinal = bdd.ref(bdd.or(xfinal, x3));
        xfinal = bdd.ref(bdd.or(xfinal, x4));
        xfinal = bdd.ref(bdd.or(xfinal, x5));
        xfinal = bdd.ref(bdd.or(xfinal, x6));
        xfinal = bdd.ref(bdd.or(xfinal, x7));
        xfinal = bdd.ref(bdd.or(xfinal, x8));

        xfinal = bdd.not(xfinal);


        bdd.printSet(xfinal);
        Controller controller = new Controller();

        String expression1 = controller.expressionScanner(bdd, xfinal);
        controller.createNodes(numberOfNodes);
        controller.createNodesCollection(expression1, numberOfNodes);
        controller.addNodes();
        controller.colorNodes(kolor);


        bdd.printSet(xfinal);
        bdd.printCubes(xfinal);

        long stop = System.nanoTime();
        System.out.println("Czas wykonania (w nanosekundach): " + (stop - start));
    }
}