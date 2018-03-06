import java.util.*;

public class BoardHandler<T> {

  private static String swap(String board, int tile1, int tile2){
    char a = board.charAt(tile1), b = board.charAt(tile2);
    StringBuilder boardAfter = new StringBuilder(board);
    boardAfter.setCharAt(tile1, b);
    boardAfter.setCharAt(tile2, a);
    return boardAfter.toString();
  }

  public static String upSwap(String board, int blankPos){
    if(blankPos < 4) return null;
    return swap(board, blankPos, blankPos - 4);
  }

  public static String downSwap(String board, int blankPos){
    if(blankPos > 11) return null;
    return swap(board, blankPos, blankPos + 4);
  }

  public static String leftSwap(String board, int blankPos){
    if(blankPos % 4 == 0) return null;
    return swap(board, blankPos, blankPos - 1);
  }

  public static String rightSwap(String board, int blankPos){
    if((blankPos + 1) % 4 == 0) return null;
    return swap(board, blankPos, blankPos + 1);
  }

  public static String shuffle(String board, int moves){
    Random randomX = new Random(System.currentTimeMillis());
    String boardAfter = board, auxBoard = null;
    int leftMoves = moves;
    int blankPos = 0;
    while(leftMoves-- != 0){

      blankPos = boardAfter.indexOf('#');
      switch(randomX.nextInt(4)){

        case 0:
          auxBoard = upSwap(boardAfter, blankPos);
          break;

        case 1:
          auxBoard = downSwap(boardAfter, blankPos);
          break;

        case 2:
          auxBoard = leftSwap(boardAfter, blankPos);
          break;

        case 3:
          auxBoard = rightSwap(boardAfter, blankPos);
          break;
      }
      if(auxBoard == null){
        leftMoves++;
      }else{
        boardAfter = auxBoard;
      }
    }
    return boardAfter;
  }

  public static String printBoard(String board){
    StringBuilder sb = new StringBuilder(board);
    for(int i=16; i>0; i-=4)
      sb.insert(i, '\n');
    System.out.println(sb.toString());
    return sb.toString();
  }

}
