
import jdd.bdd.BDD;
import jdd.bdd.BDDIO;
import jdd.bdd.BDDPrinter;
import jdd.bdd.Permutation;
import jdd.bdd.sets.BDDSet;
import jdd.util.JDDConsole;
import jdd.util.TextAreaTarget;
import jdk.nashorn.internal.runtime.ParserException;
import sun.util.resources.cldr.be.CurrencyNames_be;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;


public class DemoApplication {

 public static String expressionScanner(BDD bdd,int xfinal)
{
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
// IMPORTANT: Save the old System.out!
    PrintStream old = System.out;
// Tell Java to use your special stream
    System.setOut(ps);
// Print some output: goes to your special stream
    bdd.printSet(xfinal);
    // System.out.println("Foofoofoo!");
// Put things back
    System.out.flush();
    System.setOut(old);
// Show what happened
    // System.out.println("Here: " + baos.toString()+"koniec");
    return baos.toString();
}

    // Driver program to test above functions
    public static void main(String[] args) throws IOException {
        long start=System.nanoTime();
        int kolor=1;
        BDD bdd = new BDD(10000,1000);
        int numberOfNodes=6;
        int v1 = bdd.createVar();
        int v2 = bdd.createVar();
        int v3 = bdd.createVar();
        int v4 = bdd.createVar();
        int v5 = bdd.createVar();
        int v6 = bdd.createVar();


        int x1 = bdd.ref( bdd.and(v1,v2) );
        int x2 = bdd.ref( bdd.and(v1,v4) );
        int x3 = bdd.ref( bdd.and(v1,v6) );
        int x4 = bdd.ref( bdd.and(v2,v3) );
        int x5 = bdd.ref( bdd.and(v2,v5) );
        int x6 = bdd.ref( bdd.and(v2,v6) );
        int x7 = bdd.ref( bdd.and(v3,v5) );
        int x8 = bdd.ref( bdd.and(v5,v6) );

        int xfinal=bdd.ref( bdd.or(x1,x2) );
        xfinal=bdd.ref( bdd.or(xfinal,x3) );
        xfinal=bdd.ref( bdd.or(xfinal,x4) );
        xfinal=bdd.ref( bdd.or(xfinal,x5) );
        xfinal=bdd.ref( bdd.or(xfinal,x6) );
       xfinal=bdd.ref( bdd.or(xfinal,x7) );
        xfinal=bdd.ref( bdd.or(xfinal,x8) );



        xfinal= bdd.not(xfinal) ;
        bdd.printSet(xfinal);

        String expression1=expressionScanner(bdd,xfinal);




        List<Node> nodes = new ArrayList<>();
        List<List<String>> nodesCollection = new ArrayList<>();
        List<String> stringNode = new ArrayList<>();
        
        for (int i=1;i<numberOfNodes+1;i++)
            nodes.add(new Node(i));
for (int k=numberOfNodes+2;k<expression1.length()-numberOfNodes;k=k+numberOfNodes+2)
    stringNode.add(expression1.substring(k,k+numberOfNodes));


for(int i=0;i<stringNode.size();i++){
    List<String> lista1=new ArrayList<>();
    nodesCollection.add(lista1);
    for (int j = 0; j < numberOfNodes; j++) {
        if (stringNode.get(i).charAt(j) != '0') {
            nodesCollection.get(i).add(nodes.get(j).nameOfNode);
        }
    }
}

for(int l=0;l<nodesCollection.size();l++)
{
   // nodesCollection.
}
        Collections.sort(nodesCollection, (d1, d2) -> {
            return d2.size() - d1.size();
        });


        bdd.printSet(xfinal);
        bdd.printCubes(xfinal);

for(int i=0;i<nodesCollection.size();i++) {

    Collections.sort(nodesCollection, (d1, d2) -> {
        return d2.size() - d1.size();
    });

    for (int j = 0; nodesCollection.get(0).size()!=0;)
    {
String a=nodesCollection.get(j).get(j);
        System.out.println(nodesCollection.get(j).get(j)+"  kolor  " +kolor+"\n");

        for(int k=0;k<nodesCollection.size();k++) {
            //System.out.println("Usuwam " +a +" z  " +nodesCollection.get(k)+"\n");
            nodesCollection.get(k).remove(a);
        }
    }
    kolor=kolor+1;
}

        long stop=System.nanoTime();
        System.out.println("Czas wykonania (w nanosekundach): "+(stop-start));
    }
    }