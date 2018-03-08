public class TypicSearch {

  protected SearchList<GraphNode> list;
  protected Graph graph;

  public TypicSearch(SearchList<GraphNode> list){
    this.list = list;
    this.graph = new Graph();
  }

  public int search(String init, String dest){
    GraphNode aux = new GraphNode(init, null);
    this.list.clear();
    this.graph.clear();
    this.list.add(aux);
    this.graph.nodes.put(init, aux);
    aux = null;

    while((aux = list.remove()) != null && !aux.state.equalsIgnoreCase(dest)){

      for (int i = 0; i < 4 ; i++){
        if(aux.childs[i] != null && !this.graph.wasCreated(aux.childs[i], aux.state, null)){
          this.list.add(this.graph.nodes.get(aux.childs[i]));
        }
      }
    }
    this.graph.getPath(aux);
    return this.graph.depth;
  }

  public int[] lastStatistics(){
    System.out.println("Total nodos expandidos: " + this.graph.nodes.size());
    System.out.println("Numero maximo de nodos en memoria: " + this.list.maxSize + "\n");
    return new int[]{this.graph.nodes.size(), this.list.maxSize};
  }
}
