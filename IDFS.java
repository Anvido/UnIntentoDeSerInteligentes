public class IDFS {

  public final int INITIAL_DEPTH = 2;
  protected Graph graph;

  public IDFS(){
    this.graph = new HashMap();
  }

  public void search(String init, String dest){
    GraphNode aux = null;

    for (int i = this.INITIAL_DEPTH; true ; i += 2) {
      graph.nodes.clear();
      graph.wasCreated(init, null);
      aux = dfsRecursive(graph.nodes.get(init), dest, 0, i);
      if(aux != null && aux.state.equalsIgnoreCase(dest)){
        graph.getPath(aux);
        return ;
      }
    }
  }

  protected GraphNode dfsRecursive(GraphNode node, String dest, int depth, int max_depth){
    GraphNode aux = null;
    if(node.state.equalsIgnoreCase(dest)){ return node; }
    if(depth > max_depth){ return null; }
    for (int i = 0; i < 4 ; i++) {
      if(aux == null && node.childs[i] != null && !graph.wasCreated(node.childs[i], node.state)){
        aux = dfsRecursive(graph.nodes.get(node.childs[i]), dest, depth + 1, max_depth);
      }
    }
    return aux;
  }
}
