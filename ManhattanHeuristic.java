public class ManhattanHeuristic implements Heuristic {
  @Override
  public int calculate(String state){
    int aux = 0;
    int count = 0;
    for(int i = 0; i < state.length(); i++){
       aux = state.charAt(i);
       if(aux == 35){ continue; }
       if(aux < 58){ aux -= 49; }
       else{ aux -= 56; }
       count += Math.abs(i%4-aux%4) + Math.abs(i/4-aux/4);
    }
    return count;
  }
}
