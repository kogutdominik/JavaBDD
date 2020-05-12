
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



    // Driver program to test above functions
    public static void main(String[] args) throws IOException {
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

        bdd.printCubes(xfinal);
        bdd.printSet(xfinal);


        xfinal= bdd.not(xfinal) ;




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
        System.out.println("Here: " + baos.toString()+"koniec");
        String expression1=baos.toString();

        List<Node> nodes = new ArrayList<>();
        List<List<String>> nodesCollection = new ArrayList<>();
        List<String> nodes1 = new ArrayList<>();
        for (int i=1;i<numberOfNodes+1;i++)
            nodes.add(new Node(i));
for (int k=numberOfNodes+2;k<expression1.length()-numberOfNodes;k=k+numberOfNodes+2)
    nodes1.add(expression1.substring(k,k+numberOfNodes));


for(int i=0;i<nodes1.size();i++){
    List<String> lista1=new ArrayList<>();
    nodesCollection.add(lista1);
    for (int j = 0; j < numberOfNodes; j++) {
        if (nodes1.get(i).charAt(j) != '0') {
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


//nodesCollection.sort(new ListComparator<>());
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

       // bdd.printCubes(y);



       // junit.textui.TestRunner.run(BasicTests.class);
//        final FormulaFactory f = new FormulaFactory();
//        final Variable a = f.variable("A");
//        final Variable b = f.variable("B");
//        final Literal notC = f.literal("C", false);
//        final Formula formula = f.and(a, f.not(f.or(b, notC)));
//
//        BDD x1,y1,z1;
//
//        BDDFactory.init(1000,100);
//BDDVarSet.DefaultImpl d;
// TestBDDFactory a2,b2,b3;
// TestBDDFactory.init(1000,100);
//
//
//
//
//
//
//
//
//        final FormulaFactory f1 = new FormulaFactory();
//        final PropositionalParser p = new PropositionalParser(f1);
//        final Formula formula1 = p.parse("A & 1");
//
//        final Formula aaa=formula1.nnf();
//        final Formula nnf = formula.nnf();
//        final Formula cnf = formula.cnf();
//        final SATSolver miniSat = MiniSat.miniSat(f);
//        miniSat.add(formula);
//        final Tristate result = miniSat.sat();
//        System.out.println(result);
//        System.out.println(nnf);
//        System.out.println(cnf);
//        System.out.println(aaa);
//        Assert.assertTrue(hasNext());
//        BDDFactory bdd =nextFactory();
//        BDD x = bdd.zero();
//        BDD y = bdd.one();


    }
    }