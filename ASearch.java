import java.util.*;

public class ASearch{

  protected PriorityQueue<BigNode> heap;
  protected Heuristic function;
  protected Graph graph;

  public ASearch(Heuristic function){
    this.heap = new PriorityQueue();
    this.function = function;
    this.graph = new Graph();
  }

  public void search(String init, String dest){

  }


}
