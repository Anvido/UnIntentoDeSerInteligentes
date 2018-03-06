public class BigNode extends GraphNode implements Comparable<BigNode>{
  public int depth;
  public int totalCost;

  public BigNode(String state, String parent, int depth, int heuristic){
    super(state, parent);
    this.depth = depth;
    this.totalCost = depth + heuristic;
  }

  // public void setTotalCost(int heuristics){
  //   this.totalCost = this.depth + heuristics;
  // }

  @Override
  public int compareTo(BigNode other){
    return (this.totalCost < other.totalCost) ? -1 :
           (this.totalCost > other.totalCost) ? 1 : 0;
  }
}
