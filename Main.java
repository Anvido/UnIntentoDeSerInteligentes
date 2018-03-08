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

import java.util.HashMap;

public class Main {
  public static void main(String[] Args){

    final String dest = "123456789ABCDEF#";
    String board = BoardHandler.shuffle(dest, 15);
    AngryKidHeuristic AKH = new AngryKidHeuristic();
    ManhattanHeuristic MH = new ManhattanHeuristic();

    HashMap<Integer, String> names = new HashMap();
    names.put(0, "BFS:");
    names.put(1, "IDFS:");
    names.put(2, "Uniform Cost:");
    names.put(3, "A* with AngryKidHeuristic:");
    names.put(4, "A* with ManhattanHeuristic:");

    TypicSearch BFS = new TypicSearch(new MyQueue());
    // TypicSearch DFS;
    IDFS IDFS = new IDFS();
    UC_ASearch UC = new UC_ASearch();
    UC_ASearch AK = new UC_ASearch(AKH);
    UC_ASearch M = new UC_ASearch(MH);

    int[][] totalNodes = new int[5][30], maxNodes = new int[5][30];
    int[] stats;
    for(int i = 0; i < 30; i++){
      System.out.println("\nPrueba #"+(i+1)+":");
      board = BoardHandler.shuffle(dest, 15);


      System.out.println(names.get(0));
      System.out.println("Moves:\t" + BFS.search(board, dest));
      stats = BFS.lastStatistics();
      totalNodes[0][i] = stats[0];
      maxNodes[0][i] = stats[1];

      // DFS = new TypicSearch(new MyStack());
      // System.out.println("Moves DFS:\t"+DFS.search(board, dest));

      System.out.println(names.get(1));
      System.out.println("Moves:\t" + IDFS.search(board, dest));
      stats = IDFS.lastStatistics();
      totalNodes[1][i] = stats[0];
      maxNodes[1][i] = stats[1];


      System.out.println(names.get(2));
      System.out.println("Moves:\t" + UC.search(board, dest));
      stats = UC.lastStatistics();
      totalNodes[2][i] = stats[0];
      maxNodes[2][i] = stats[1];


      System.out.println(names.get(3));
      System.out.println("Moves:\t" + AK.search(board, dest));
      stats = AK.lastStatistics();
      totalNodes[3][i] = stats[0];
      maxNodes[3][i] = stats[1];


      System.out.println(names.get(4));
      System.out.println("Moves:\t" + M.search(board, dest));
      stats = M.lastStatistics();
      totalNodes[4][i] = stats[0];
      maxNodes[4][i] = stats[1];
    }

    System.out.println();

    double[] avgTotalNodes = new double[5], avgMaxNodes = new double[5];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 30; j++) {
        avgTotalNodes[i] += totalNodes[i][j];
        avgMaxNodes[i] += maxNodes[i][j];
      }
      System.out.println(names.get(i));
      avgTotalNodes[i] /= 30;
      avgMaxNodes[i] /= 30;
      System.out.println("Average total nodes: " + avgTotalNodes[i]);
      System.out.println("Average max nodes in memory: " + avgMaxNodes[i] + "\n");
    }

    System.out.println();

    double[] sdTotalNodes = new double[5], sdMaxNodes = new double[5];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 30; j++) {
          sdTotalNodes[i] += Math.pow(totalNodes[i][j] - avgTotalNodes[i], 2);
          sdMaxNodes[i] += Math.pow(maxNodes[i][j] - avgMaxNodes[i], 2);
      }
      System.out.println(names.get(i));
      sdTotalNodes[i] = Math.sqrt(sdTotalNodes[i]/30);
      sdMaxNodes[i] = Math.sqrt(sdMaxNodes[i]/30);
      System.out.println("Standard deviation total nodes: " + sdTotalNodes[i]);
      System.out.println("Standard deviation max nodes in memory: " + sdMaxNodes[i] + "\n");
    }
  }
}
