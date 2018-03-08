public class IDFS {
  public final int INITIAL_DEPTH = 2;
  protected Graph graph;
  public int expanddedNodes;
  public int maxSize;
  MyStack<GraphNode> stack;

  public IDFS(){
    this.graph = new Graph();
    this.expanddedNodes = 0;
    this.maxSize = 0;
    this.stack = new MyStack();
  }

  public int search(String init, String dest){
    GraphNode aux = null;
    GraphNode initialNode = new GraphNode(init, null);
    for (int i = this.INITIAL_DEPTH; true ; i += 2) {
      this.graph.nodes.clear();
      this.graph.nodes.put(init, initialNode);
      this.stack.add(initialNode);
      aux = null;

      while((aux = this.stack.remove()) != null && !aux.state.equalsIgnoreCase(dest)){
        for (int j = 0; j < 4; j++) {
          if(aux.depth + 1 > i){
            break;
          }
          if(aux.childs[j] != null){
            if(!this.graph.wasCreated(aux.childs[j], aux.state, new int[]{aux.depth + 1, 0})){
              this.stack.add(this.graph.nodes.get(aux.childs[j]));
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
