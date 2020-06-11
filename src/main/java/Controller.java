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
/*Utworzenie głównej listy wierzcholkow, mającej (numberOfNodes) elementów*/
    public void createNodes(int numberOfNodes) {
        for (int i = 0; i < numberOfNodes; i++)
            nodes.add(new Node(i + 1));                                                                //Numeracja zaczyna się od V1
    }
/*Dodawanie kolejnych PUSTYCH zbiorow wierzcholkow do listy, pozniej dopiero przypisywane sa odpowiednie wiercholki */
    public void createNodesCollection(int numberOfNodes) {
        for (int k = numberOfNodes + 2; k < bddExpression.length() - 4; k = k + numberOfNodes + 2)                   //start od "2" korzenia; dopki nie zczyta wszystkiego-pierwszy korzen;zwiekszaj oilosc wirzcholkow \n\r
            this.nodesCollection.add(new NodesCollection(bddExpression.substring(k, k + numberOfNodes)));           //zbior wierzcholkow z pomienieciem pierwszego elementu "/n/r" traktowane jako 2 znaki
    }
/*Dodawanie kolejnych wierzcholkow do zbioru wierchollkow||Okreslenie maksymalnych zbiorow niezaleznych*/
    public void addNodes() {
        for (int j = 0; j < nodesCollection.size(); j++) {                                                          //dla wszystkich elementow listy nodesCollection
            for (int i = 0; i < nodesCollection.get(j).stringOfExpression.length(); i++) {                          //dlugosc stringOfExpression = liczbie wierzcholkow,
                if (nodesCollection.get(j).stringOfExpression.charAt(i) != '0') {                                   //jezei w korzeniu drzewa "-" lub "1"
                    nodesCollection.get(j).nodes.add(nodes.get(i));                                                 //dodajemy dany wierzcholek do konkretnego zbioru z listy
                }
            }
        }
    }
/*Kolorowanie wierzcholkow i jednoczesne usuwanie pokolorowanych ze wszystkich zbiorow z listy nodesCollection*/
    public void colorNodes() {
        for (int i = 0; i < nodesCollection.size(); i++) {                                                          //wszystkie zbiory niezalezne
            Collections.sort(nodesCollection, (d1, d2) -> {                                                         //sortowanie po ilosci wierzcholkow  w zbiorze od najweiekszej do najmniejszej
                return d2.nodes.size() - d1.nodes.size();                                                           //z uzyciem wyrazenia lambda
            });
            if (nodesCollection.get(0).nodes.size() != 0)                                                           //jezeli zbior 1(z najwieksza liczba elementow) nie jest pusty
                color = color + 1;                                                                                  //nastepny kolor
            for (; nodesCollection.get(0).nodes.size() != 0; ) {                                                    //kolorowanie i usuwanie, petla wykonuje sie dopki zbior nie jest pusty
                nodeTemp = nodesCollection.get(0).nodes.get(0);                                                     //zmienna tymczasowa dla uproszzenia kodu, 0 element z 0 zbioru(najbardziel licznego)
                nodes.get(nodes.indexOf(nodeTemp)).setColour(color);                                                //ustawienie koloru w GLOWNEJ liscie wierzcholkow
                for (int k = 0; k < nodesCollection.size(); k++) {                                                  //dla wszytskich zbiorow z listy zbiorow
                    nodesCollection.get(k).nodes.remove(nodeTemp);                                                  //usuwamy pokolorowany wierzcholek
                }                                                                                                   //
            }
        }

        for (int i = 0; i < nodes.size(); i++) {                                                                    //pokolorowanie dodatkowe wierzcholkow nieuwzglednionych w korzeniu
            if (nodes.get(i).getColour() == 0)                                                                      //jezeli nie zostal jeszcze pokorowany
                nodes.get(i).setColour(color + 1);                                                                  //przypis wszystkim niepokolorowanym (kazdy z nich jest zbiorem neizaleznym) ten sam kolor
        }
        System.out.println("\nLiczba użytych kolorów: " + (color));                                                  //wyswietlenie informacji o iosci kolorow
    }
/*Zczytanie informacji z metody printSet zaimplementowanej w wykorzystanej bibliotece */
    public void expressionScanner(BDD bdd, int xfinal) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;                                                                               //zapisanie System.out do obiektu, by mozna bylo wrocic do neigo
        System.setOut(ps);                                                                                          //ustawienie stworzonego predzej obiektu jako bufora
        bdd.printSet(xfinal);                                                                                       //wyowolanie metody
        System.out.flush();                                                                                         //zapis wprowadzonych danych
        System.setOut(old);                                                                                         //przywrocenie starego buforu
        bddExpression = baos.toString();                                                                            //zapis odczytanych informacji do zmiennej bddExpression
    }
/*Wyswietlenie nazwy i koloru kazdego wierzcholka z listy GLOWNEJ*/
    public void printColor() {
        for (int i = 0; i < nodes.size(); i++)
            System.out.println(nodes.get(i).toString());
    }
}