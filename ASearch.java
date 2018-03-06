import java.util.*;

public class ASearch {

  protected PriorityQueue<GraphNode> heap;
  protected Heuristic function;
  protected Graph graph;

  public ASearch(Heuristic function){
    this.heap = new PriorityQueue();
    this.function = function;
    this.graph = new Graph();
  }

  public void search(String init, String dest){
    int[] args = new int[2]; // 0 -> depth, 1 -> heuristic
    args[0] = 0;
    args[1] = this.function.calculate(init);
    GraphNode aux = new GraphNode(init, null, args[0], args[1]);
    this.graph.nodes.put(init, aux);
    this.heap.offer(aux);

    while(!this.heap.isEmpty()){
      aux = this.heap.poll();
      System.out.println("size: " + this.heap.size());
      System.out.println("aux state:");
      BoardHandler.printBoard(aux.state);

      if(aux.state.equalsIgnoreCase(dest)){

        this.graph.getPath(aux);
        System.out.println("Moves: " + this.graph.depth);
        break;
      }

      System.out.println("aux childs:");
      for (int i = 0; i < 4; i++){
        if(aux.childs[i] != null){
          args[0] = aux.depth + 1;
          args[1] = this.function.calculate(aux.childs[i]);
          BoardHandler.printBoard(aux.childs[i]);
          if(!this.graph.wasCreated(aux.childs[i], aux.state, args)){
            this.heap.offer(this.graph.nodes.get(aux.state));
          }
        }
      }
    }
  }
}
