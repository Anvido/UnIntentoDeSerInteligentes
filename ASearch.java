import java.util.*;

public class ASearch{

  protected PriorityQueue<BigNode> heap;
  protected Heuristic function;
  protected Graph<BigNode> graph;

  public ASearch(Heuristic function){
    this.heap = new PriorityQueue();
    this.function = function;
    this.graph = new Graph();
  }

  public void search(String init, String dest){
    int heuristic = this.function.calculate(init);
    BigNode aux;
    this.graph.wasCreated(init, null, 0, heuristic);
    this.heap.offer(this.graph.nodes.get(init));

    while(!this.heap.isEmpty()){
      aux = this.heap.poll();

      if(aux.state.equalsIgnoreCase(dest)){
        graph.getPath(aux);
        break;
      }

      for (int i = 0; i < 4; i++){
        if(aux.childs[i] != null){
          heuristic = this.function.calculate(aux.childs[i]);
          if(!this.graph.wasCreated(aux.childs[i], aux.state, aux.depth + 1, heuristic)){
            this.heap.offer(this.graph.nodes.get(aux.state));
          }
        }
      }
    }
  }
}
