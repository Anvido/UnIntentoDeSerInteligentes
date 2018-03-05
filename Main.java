/*
Programa de puzzle 4*4, desordenado por 15 movinientos aleatorios y aplicando
distintos tipos de busquedas sobre el para llegar a la solucion.

* BFS
* DFS
* DFS iterado
* Costo Uniforme
* A* 2 Heuristicas (Chino rabon y Manhattan)

30 experimentos que incluyen tiempos de busquedas, tiempo promedio,
desviacion estandar, numero de nodos expandidos, maximo numero de nodos en
memoria.
*/

/*
1 2 3 #
5 6 7 4
9 A B 8
D E F C
*/
// "123456789AFBDE#C"

class Main {
  public static void main(String[] Args){

    final String dest = "123456789ABCDEF#";
    String board = BoardHandler.shuffle(dest, 15);

    System.out.println("Inicio:\n\n");
    BoardHandler.printBoard(board);

    TypicSearch BFS = new TypicSearch(new MyQueue());
    BFS.search(board, dest);
  }
}
