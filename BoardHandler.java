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
    int leftMoves = moves, lastMove = 0, currentMove = 0;
    int blankPos = boardAfter.indexOf('#');
    while(leftMoves != 0){

      switch(currentMove = randomX.nextInt(4)){

        case 0:
          if(lastMove != 1){
            auxBoard = upSwap(boardAfter, blankPos);
          }
          break;

        case 1:
          if(lastMove != 0){
            auxBoard = downSwap(boardAfter, blankPos);
          }
          break;

        case 2:
          if(lastMove != 3){
            auxBoard = leftSwap(boardAfter, blankPos);
          }
          break;

        case 3:
          if(lastMove != 2){
            auxBoard = rightSwap(boardAfter, blankPos);
          }
          break;
      }
      if(auxBoard != boardAfter && auxBoard != null){
        boardAfter = auxBoard;
        leftMoves--;
        lastMove = currentMove;
        blankPos = boardAfter.indexOf('#');
      }
    }
    return boardAfter;
  }

  public static String printBoard(String board){
    StringBuilder sb = new StringBuilder(board);
    for(int i=16; i>0; i-=4)
      sb.insert(i, '\n');
    return sb.toString();
  }

}
