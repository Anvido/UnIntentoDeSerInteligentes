public class GraphNode {
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

  @Override
  public String toString(){
    // return this.state;
    StringBuilder sb = new StringBuilder(this.state);
    for(int i=16; i>0; i-=4)
      sb.insert(i, '\n');
    return sb.toString();
  }
}
