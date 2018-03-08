import java.util.PriorityQueue;

public class UC_ASearch {

  protected PriorityQueue<GraphNode> heap;
  protected Heuristic function;
  protected Graph graph;
  public int maxSize;

  public UC_ASearch(Heuristic function){
    this.heap = new PriorityQueue();
    this.function = function;
    this.graph = new Graph();
    this.maxSize = 1;
  }

  public UC_ASearch(){
    this.heap = new PriorityQueue();
    this.function = null;
    this.graph = new Graph();
    this.maxSize = 1;
  }

  public int search(String init, String dest){
    int[] args = new int[2]; // 0 -> depth, 1 -> heuristic
    args[0] = 0;
    args[1] = (this.function == null) ? 0 : this.function.calculate(init);
    GraphNode aux = new GraphNode(init, null, args[0], args[1]);
    this.graph.nodes.put(init, aux);
    this.heap.offer(aux);

    while(!this.heap.isEmpty()){
      aux = this.heap.poll();

      if(!aux.wasVisited){

        aux.wasVisited = true;
        if(aux.state.equalsIgnoreCase(dest)){
          this.graph.getPath(aux);
          return this.graph.depth;
        }

        for (int i = 0; i < 4; i++){
          if(aux.childs[i] != null){
            args[0] = aux.depth + 1;
            args[1] = (this.function == null) ? 0 : this.function.calculate(aux.childs[i]);
            this.graph.wasCreated(aux.childs[i], aux.state, args);
            if(!this.graph.nodes.get(aux.childs[i]).wasVisited){
              this.heap.offer(this.graph.nodes.get(aux.childs[i]));
              if(this.heap.size() > this.maxSize){
                this.maxSize ++;
              }
            }
          }
        }
      }
    }
    return -1;
  }

  public int[] lastStatistics(){
    System.out.println("Numero de nodos expandidos: " + this.graph.nodes.size());
    System.out.println("Numero maximo de nodos en memoria: " + this.maxSize + "\n");
    return new int[]{this.graph.nodes.size(), this.maxSize};
  }
}
