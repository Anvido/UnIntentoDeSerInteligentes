import java.util.*;

public class Graph {

  protected HashMap<String, GraphNode> nodes;
  protected int depth;

  public Graph(){
    this.nodes = new HashMap();
    this.depth = 0;
  }

  public boolean wasCreated(String state, String parent, int[] args){
    if(!this.nodes.containsKey(state)){
      this.nodes.put(state,
      (args == null) ? new GraphNode(state, parent) :
      new GraphNode(state, parent, args[0], args[1]));
      return false;
    }
    return true;
  }

  public int generatedNodes(){
    return this.nodes.size();
  }

  public void getPath(GraphNode node){
    if(node.parent != null){
      this.depth++;
      getPath(this.nodes.get(node.parent));
    }
    // System.out.println(node);
  }
}
