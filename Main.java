import java.io.*;
import java.util.*;
/*
Programa de puzzle 4*4, desordenado por 15 movinientos aleatorios y aplicando
distintos tipos de busquedas sobre el para llegar a la solucion.

* BFS
* DFS
* DFS iterado
* Costo Uniforme
* A*
* 2 Heuristicas (Chino rabon y Manhattan)

30 experimentos que incluyen tiempos de busquedas, tiempo promedio,
desviacion estandar, numero de nodos expandidos, maximo numero de nodos en
memoria.
*/

class Main {
  public static void main(String[] Args){
    String board = "123456789ABCDEF#";
    board = BoardHandler.shuffle(board);
    int posVechio = board.indexOf('#');

    System.out.println("Arriba: " + BoardHandler.upSwap(board, posVechio));
    System.out.println("Abajo: " + BoardHandler.downSwap(board, posVechio));
    System.out.println("Izquierda: " + BoardHandler.leftSwap(board, posVechio));
    System.out.println("Derecha: " + BoardHandler.rightSwap(board, posVechio));
  }
}
