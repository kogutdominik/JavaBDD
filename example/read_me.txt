Zestaw plików do testów. Pliki z rozszerzeniem ".bat" umożliwiają szybkie otwarcie programów ".jar"napisanych w JAVIE.

***GraphGenerator.jar*** --- własny program do generacji grafów o określonej liczbie wierzchołków i krawędzi
***BDDkolorowanie.jar*** --- program z własnym zaimplementowanym algorytmem kolorowania wykorzystującym BDD
***Greedy(beta).jar***   --- prosty program zawierający wyłącznie zaimplementowany algorytm "greedy" użyty do kolorowania 
***Greedy.jar***         --- implementacja algorytmu greedy z wykorzystaniem biblioteki JgraphT  
***GreedySL.jar***       --- implementacja algorytmu greedy z uporządkowaniem SL z wykorzystaniem biblioteki JgraphT  
***Brown.jar***          --- implementacja algorytmu Brown backtrack z wykorzystaniem biblioteki JgraphT  


Sposób użycia:
1. Otworzyć plik "1 GraphGenerator.bat" plik wykonywalny uruchamia program do generowania grafów. 
a)podać liczbę wierzchołków, zatwierdzić ENTEREM
b)podać liczbę krawędzi, zatwierdzić ENTEREM
c)nacisnąć dowolny klawisz w celu zakończenia programu
2. Stworzony został plik "Graf_testowy1.txt", otwierając go, można zobaczyć w pierwszym wierszu liczbę wierzchołków i krawędzi, kolejne wiersze reprezentują macierz sąsiedztwa.
3. Otworzyć plik "2 BDDkolorowanie.bat" (program automatycznie wczyta dane z uprzednio utworzonego pliku "Graf_testowy1.txt).
4. W programie widoczne jest:
+++ zużycie pamięci RAM przed dodaniem zmiennych do drzewa BDD
+++ zużycie po dodaniu i po wykonaniu równań logicznych
+++ liczby kolorów użytych do pokolorowania grafu
+++ nazwy wierzchołków(ich numery) wraz z przyporządkowanym kolorem
+++ czas wykonania się programu
5. Otworzyć interesujący nas plik z innym algorytmem. 
6. Porównać czas i liczbę użytych kolorów.
