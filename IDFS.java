import java.util.*;

public class IDFS {

  public final int INITIAL_DEPTH = 2;
  protected Graph graph;

  public IDFS(){
    this.graph = new Graph();
  }

  public void search(String init, String dest){
    GraphNode aux = null;
    GraphNode initialNode = new GraphNode(init, null);
    for (int i = this.INITIAL_DEPTH; true ; i += 2) {
      this.graph.nodes.clear();
      this.graph.nodes.put(init, initialNode);
      aux = dfsRecursive(initialNode, dest, 0, i);
      if(aux != null && aux.state.equalsIgnoreCase(dest)){
        graph.getPath(aux);
        System.out.println("Moves with IDFS: " + graph.depth);
        return ;
      }
    }
  }

  protected GraphNode dfsRecursive(GraphNode node, String dest, int depth, int max_depth){
    GraphNode aux = null;
    if(node.state.equalsIgnoreCase(dest)){ return node; }
    if(depth > max_depth){ return null; }
    for (int i = 0; i < 4 ; i++) {
      if(aux == null && node.childs[i] != null && !graph.wasCreated(node.childs[i], node.state, null)){
        aux = dfsRecursive(graph.nodes.get(node.childs[i]), dest, depth + 1, max_depth);
      }
    }
    return aux;
  }
}
