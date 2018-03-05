import java.util.*;

public class Graph {

  protected HashMap<String, GraphNode> nodes;

  public Graph(){
    this.nodes = new HashMap();
  }

  public boolean wasVisited(String state, String parent){
    if(!this.nodes.containsKey(state)){
      this.nodes.put(state, new GraphNode(state, parent));
      return false;
    }
    return true;
  }

  public int generatedNodes(){
    return this.nodes.size();
  }

  public void getPath(GraphNode node){
    if(node.parent != null){
      getPath(this.nodes.get(node.parent));
    }
    System.out.println(node);
  }
}
