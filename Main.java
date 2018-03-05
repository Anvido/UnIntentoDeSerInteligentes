import java.io.*;
import java.util.*;
/*
Programa de puzzle 4*4, desordenado por 15 movinientos aleatorios y aplicando
distintos tipos de busquedas sobre el para llegar a la solucion.

* BFS
* DFS
* DFS iterado* Costo Uniforme
* A* 2 Heuristicas (Chino rabon y Manhattan)

30 experimentos que incluyen tiempos de busquedas, tiempo promedio,
desviacion estandar, numero de nodos expandidos, maximo numero de nodos en
memoria.
*/

/*
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 #
*/

class Main {
  public static void main(String[] Args){
    // String board = "123456789AFBDE#C";
    String board = "123456789ABCDEF#";
    board = BoardHandler.shuffle(board, 15);

    System.out.println("Inicio: \n" + new GraphNode(board, null) + "\n\n");


    TypicSearch s = new TypicSearch(new MyQueue());
    s.search(board, "123456789ABCDEF#");
    // System.out.println("Arriba: " + BoardHandler.upSwap(board, posVechio));
    // System.out.println("Abajo: " + BoardHandler.downSwap(board, posVechio));
    // System.out.println("Izquierda: " + BoardHandler.leftSwap(board, posVechio));
    // System.out.println("Derecha: " + BoardHandler.rightSwap(board, posVechio));
  }
}
