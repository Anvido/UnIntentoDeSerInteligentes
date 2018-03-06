public class TypicSearch {

  protected SearchList<GraphNode> list;

  public TypicSearch(SearchList<GraphNode> list){
    this.list = list;
  }

  public void search(String init, String dest){
    Graph graph = new Graph();
    GraphNode aux = new GraphNode(init, null);
    this.list.add(aux);
    graph.nodes.put(init, aux);
    aux = null;

    while((aux = list.remove()) != null && !aux.state.equalsIgnoreCase(dest)){

      for (int i = 0; i < 4 ; i++){
        if(aux.childs[i] != null && !graph.wasCreated(aux.childs[i], aux.state)){
          this.list.add(graph.nodes.get(aux.childs[i]));
        }
      }
    }

    System.out.println("Solution: \n");
    graph.getPath(aux);
    System.out.println("Moves: " + graph.depth + "\n\n");
  }
}
