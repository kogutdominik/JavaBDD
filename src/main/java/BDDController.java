import jdd.bdd.BDD;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BDDController {
    private BDD bdd;
    private int numberOfNodes;
    private int numberOfEdges;
    private int xfinal = 0;
    private int nodesFromFile[];
    private int nodesAfterAndOperation[];
//    private List<Integer> nodesFromFile=new ArrayList<>();
//    private List<Integer> nodesAfterAndOperation=new ArrayList<>();

    public BDDController() {
        this.bdd = new BDD(10000, 1000);
    }

    public BDD getBdd() {
        return bdd;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }
/* odczytywanie danych z pliku*/
    int readDataFromFile(String nameOfFile) throws FileNotFoundException {
        File file = new File(nameOfFile);
        Scanner in = new Scanner(file);
        numberOfNodes = in.nextInt();                                                   //wlasciwy format pliku na pierwszy mmiejscu posiada liczbe wierzcholkow
        numberOfEdges = in.nextInt();                                                   //nastepnie podana jest liczba krawdzi
        nodesFromFile = new int[numberOfNodes];                                         //tablica wierzcholkow
        nodesAfterAndOperation = new int[numberOfEdges];                                //tablica zmiennych po zastosowaniu operacji and
        System.out.println(numberOfNodes + "   " + nodesAfterAndOperation.length);

        for (int i = 0; i < numberOfNodes; i++)                                         //
            nodesFromFile[i] = bdd.createVar();

        for (int i = 0; in.hasNext(); i++) {
            nodesAfterAndOperation[i] = bdd.ref(bdd.and(nodesFromFile[in.nextInt() - 1], nodesFromFile[in.nextInt() - 1]));
        }



        for (int i = 0; i < nodesAfterAndOperation.length; i++) {
            xfinal = bdd.ref(bdd.or(xfinal, nodesAfterAndOperation[i]));
        }


//        for (int i = 0; i < numberOfNodes; i++)                                         //
//            nodesFromFile.add( bdd.createVar()) ;
//
//        for (int i = 0; in.hasNext(); i++) {
//            nodesAfterAndOperation.add(bdd.ref(bdd.and(nodesFromFile.get(in.nextInt() - 1), nodesFromFile.get(in.nextInt() - 1))));
//        }
//
//        for (int i = 0; i < nodesAfterAndOperation.size(); i++) {
//            xfinal = bdd.ref(bdd.or(xfinal, nodesAfterAndOperation.get(i)));
//        }


        xfinal = bdd.not(xfinal);
        return xfinal;
    }
}
