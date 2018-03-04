import java.util.*;

public class Graph<T> {

  protected class GraphNode<T> {
    public T state;
    public T parent;
    public T[] childs;

    public GraphNode(T state, T parent){
      int blankPos = state.indexOf('#');
      this.state = state;
      this.parent = parent;
      this.GraphNode[] = new T[]{
        BoardHandler.upSwap(this.state, blankPos),
        BoardHandler.downSwap(this.state, blankPos),
        BoardHandler.leftSwap(this.state, blankPos),
        BoardHandler.rightSwap(this.state, blankPos)
      }
    }
  }

  protected HashMap<T, GraphNode> nodes;

  public void generateNode(T state, T parent){
    if(!this.nodes.containsKey(state)){
      this.nodes.put(state, new GraphNode(state, parent));
    }
  }

  public int generatedNodes(){
    return this.nodes.size();
  }
}
