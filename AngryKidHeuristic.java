public class AngryKidHeuristic implements Heuristic {
  @Override
  public int calculate(String state){
    int count = 0;
    int aux = 0;
    for(int i = 0; i < state.length(); i++){
      aux = state.charAt(i);
      if(aux != 35 && ((aux < 58 && aux-48 != i+1) || (aux > 64 && aux-55 != i+1))){
        count++;
      }
    }
    return count;
  }
}
