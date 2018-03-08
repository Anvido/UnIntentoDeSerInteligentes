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

public class Main {
  public static void main(String[] Args){

    final String dest = "123456789ABCDEF#";
    String board = BoardHandler.shuffle(dest, 15);
    // System.out.println(BoardHandler.printBoard(board));
    // AngryKidHeuristic AKH = new AngryKidHeuristic();
    // ManhattanHeuristic MH = new ManhattanHeuristic();

    // TypicSearch BFS;
    // TypicSearch DFS;
    IDFS IDFS;
    // UC_ASearch UC;
    // UC_ASearch AK;
    // UC_ASearch M;

    // int[][][] stats = new int[5][2][30];
    // for(int i=0; i<30; i++){
    //   System.out.println("Prueba #"+(i+1)+":");
    //   board = BoardHandler.shuffle(dest, 15);
    //
    //   BFS = new TypicSearch(new MyQueue());
    //   System.out.println("Moves BFS:\t"+BFS.search(board, dest));
      // stats[0][0][i] = BFS.expanddedNodes;
      // stats[0][1][i] = BFS.maxSize;

      // DFS = new TypicSearch(new MyStack());
      // DFS.search(board, dest);
      // stats[1][0][i] = DFS.expanddedNodes;
      // stats[1][1][i] = DFS.maxSize;

    IDFS = new IDFS();
    System.out.println("Moves IDFS:\t"+IDFS.search(board, dest));
      // stats[1][0][i] = IDFS.expanddedNodes;
      // stats[1][1][i] = IDFS.maxSize;

      // UC = new UC_ASearch();
      // System.out.println("Moves UC:\t"+UC.search(board, dest));
      // stats[2][0][i] = UC.expanddedNodes;
      // stats[2][1][i] = UC.maxSize;

      // AK = new UC_ASearch(AKH);
      // System.out.println("Moves AK:\t"+AK.search(board, dest));
      // stats[3][0][i] = AK.expanddedNodes;
      // stats[3][1][i] = AK.maxSize;

      // M = new UC_ASearch(MH);
      // System.out.println("Moves M:\t"+M.search(board, dest)+"\n");
      // stats[4][0][i] = M.expanddedNodes;
      // stats[4][1][i] = M.maxSize;
    // }

    // double[][] results = new double[5][4];
    // for(int i=0; i<5; i++){
    //   for(int k=0; k<30; k++){
    //     results[i][0] += stats[i][0][k];
    //     results[i][2] += stats[i][1][k];
    //   }
    //   resutls[i][0] /= 30;
    //   resutls[i][2] /= 30;
    //   for(int k=0; k<30; k++){
    //     results[i][1] += (stats[i][0][k] - results[i][0])*(stats[i][0][k] - results[i][0]);
    //     results[i][3] += (stats[i][1][k] - results[i][2])*(stats[i][1][k] - results[i][2]);
    //   }
    //   results[i][1] = Math.sqrt(results[i][1]/30);
    //   results[i][3] = Math.sqrt(results[i][3]/30);
    //   System.out.println(i+" prom expandidos: "+results[i][0]);
    //   System.out.println(i+" ds expandidos:   "+results[i][1]);
    //   System.out.println(i+" prom memoria:    "+results[i][2]);
    //   System.out.println(i+" ds expandidos:   "+results[i][3]);
    // }

  }
}
