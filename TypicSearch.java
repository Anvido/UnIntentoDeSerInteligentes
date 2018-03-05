import java.util.*;
import java.io.*;

public class TypicSearch {

  protected SearchList<String> list;

  public TypicSearch(SearchList<String> list){
    this.list = list;
  }

  public void search(String init, String dest){
    Graph graph = new Graph();
    String aux = null;
    this.list.add(init);
    int blankPos = 0;
    String[] auxChilds = new String[4];

    while((aux = list.remove()) != null && aux != dest){

      blankPos = aux.indexOf('#');
      auxChilds[0] = BoardHandler.upSwap(aux, blankPos);
      auxChilds[1] = BoardHandler.downSwap(aux, blankPos);
      auxChilds[2] = BoardHandler.leftSwap(aux, blankPos);
      auxChilds[3] = BoardHandler.rightSwap(aux, blankPos);

      for (int i = 0; i < 4 ; i++){
        if(!graph.wasVisited(auxChilds[i], aux)){
          this.list.add(auxChilds[i]);
        }
      }
  }
}
