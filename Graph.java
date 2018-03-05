import java.util.*;

public class Graph {

  protected class GraphNode {
    public String state;
    public String parent;
    public String[] childs;

    public GraphNode(String state, String parent){
      int blankPos = state.indexOf('#');
      this.state = state;
      this.parent = parent;
      this.childs = new String[]{
        BoardHandler.upSwap(this.state, blankPos),
        BoardHandler.downSwap(this.state, blankPos),
        BoardHandler.leftSwap(this.state, blankPos),
        BoardHandler.rightSwap(this.state, blankPos)
      };
    }
  }

  protected HashMap<String, GraphNode> nodes;

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
}
