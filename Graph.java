import java.util.*;

public class Graph<T extends GraphNode> {

  protected HashMap<String, ? extends GraphNode> nodes;
  protected int depth;

  public Graph(){
    this.nodes = new HashMap();
    this.depth = 0;
  }

  public boolean wasCreated(String state, String parent, int depth, int heuristic){
    if(!this.nodes.containsKey(state)){
      this.nodes.put(state, new BigNode(state, parent, depth, heuristic));
      return false;
    }
    return true;
  }

  public boolean wasCreated(String state, String parent){
    if(!this.nodes.containsKey(state)){
      this.nodes.put(state, new GraphNode(state, parent));
      return false;
    }
    return true;
  }

  public int generatedNodes(){
    return this.nodes.size();
  }

  public void getPath(T node){
    if(node.parent != null){
      this.depth++;
      getPath(this.nodes.get(node.parent));
    }
    // System.out.println(node);
  }
}
