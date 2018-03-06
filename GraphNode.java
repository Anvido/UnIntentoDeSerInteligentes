public class GraphNode implements Comparable<GraphNode>{
  public String state;
  public String parent;
  public int depth;
  public int totalCost;
  public String[] childs;

  public GraphNode(String state, String parent){
    this.depth = 0;
    this.totalCost = 0;
    this.leftInit(state, parent);
  }

  public GraphNode(String state, String parent, int depth, int heuristic){
    this.depth = depth;
    this.totalCost = depth + heuristic;
    this.leftInit(state, parent);
  }

  private void leftInit(String state, String parent){
    int blankPos = state.indexOf('#');
    this.state = state;
    this.parent = parent;
    this.childs = new String[]{
      BoardHandler.rightSwap(this.state, blankPos),
      BoardHandler.upSwap(this.state, blankPos),
      BoardHandler.leftSwap(this.state, blankPos),
      BoardHandler.downSwap(this.state, blankPos)
    };
  }

  @Override
  public int compareTo(GraphNode other){
    return (this.totalCost < other.totalCost) ? -1 :
           (this.totalCost > other.totalCost) ? 1 : 0;
  }

  @Override
  public String toString(){
    return BoardHandler.printBoard(this.state);
  }
}
