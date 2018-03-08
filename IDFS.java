public class IDFS {

  protected Graph graph;
  protected MyStack<GraphNode> stack;
  public int maxSize;
  public final int INITIAL_DEPTH = 2;


  public IDFS(){
    this.graph = new Graph();
    this.maxSize = 0;
    this.stack = new MyStack();
  }

  public int search(String init, String dest){
    GraphNode aux = null;
    GraphNode initialNode = new GraphNode(init, null);
    int[] args = new int[2];
    args[1] = 0;
    for (int i = this.INITIAL_DEPTH; true ; i += 2) {
      this.graph.clear();
      this.graph.nodes.put(init, initialNode);
      this.stack.clear();
      this.stack.add(initialNode);
      aux = null;

      while((aux = this.stack.remove()) != null && !aux.state.equalsIgnoreCase(dest)){
        if(aux.depth + 1 <= i){
          for (int j = 0; j < 4; j++) {
            if(aux.childs[j] != null){
              args[0] = aux.depth + 1;
              if(!this.graph.wasCreated(aux.childs[j], aux.state, args)){
                this.stack.add(this.graph.nodes.get(aux.childs[j]));
              }
            }
          }
        }
      }

      if(aux != null && aux.state.equalsIgnoreCase(dest)){
        graph.getPath(aux);
        return graph.depth;
      }
    }
  }

  public int[] lastStatistics(){
    System.out.println("Numero de nodos expandidos: " + this.graph.nodes.size());
    System.out.println("Numero maximo de nodos en memoria: " + this.stack.maxSize + "\n");
    return new int[]{this.graph.nodes.size(), this.stack.maxSize};
  }
}
