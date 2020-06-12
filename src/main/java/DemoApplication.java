import jdd.bdd.OptimizedCache;

import java.io.IOException;

public class DemoApplication {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();                                    //zmienna start do odmierzania czasu

        BDDController bddController = new BDDController();                          //obiekt klasy BDDController
        int xfinal = bddController.readDataFromFile("graf_testowy1.txt");        //xfinal(korzen drzewa decyzyjnego) jako wynik metod z biblioteki JDD
        int numberOfNodes = bddController.getNumberOfNodes();                       //zczytanie liczby wierzcholkow z pliku
        Controller controller = new Controller();                                   //kontroler realizujacy kolorowanie grafu

        controller.expressionScanner(bddController.getBdd(), xfinal);               //zczytanie danych z wywołanie metody bdd.printSet
        controller.createNodes(numberOfNodes);                                      //stworzenie listy wszystkich wierzcholkow
        controller.createNodesCollection(numberOfNodes);                            //stworz
        controller.addNodes();
        long start2 = System.currentTimeMillis();
        controller.colorNodes();
        controller.printColor();

        //bddController.bdd.printSet(xfinal);
        long stop = System.currentTimeMillis();
        System.out.println("Czas wykonania: " + (stop - start)+"ms");
        System.out.println("Czas kolorowania: " + (stop - start2)+"ms");
    }
}