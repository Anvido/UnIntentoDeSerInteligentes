import java.util.*;
import java.io.*;

public class BoardHandler {

  private static String swap(String board, int tile1, int tile2){
    char a = board.charAt(tile1), b = board.charAt(tile2);
    StringBuilder boardAfter = new StringBuilder(board);
    boardAfter.setCharAt(tile1, b);
    boardAfter.setCharAt(tile2, a);
    return boardAfter.toString();
  }

  public static String upSwap(String board, int posVechio){
    if(posVechio < 4) return null;
    return swap(board, posVechio, posVechio - 4);
  }

  public static String downSwap(String board, int posVechio){
    if(posVechio > 11) return null;
    return swap(board, posVechio, posVechio + 4);
  }

  public static String leftSwap(String board, int posVechio){
    if(posVechio % 4 == 0) return null;
    return swap(board, posVechio, posVechio - 1);
  }

  public static String rightSwap(String board, int posVechio){
    if((posVechio + 1) % 4 == 0) return null;
    return swap(board, posVechio, posVechio + 1);
  }

  public static String shuffle(String board){
    Random randomX = new Random();
    String boardAfter = board;
    int a = 0, b = 0;
    for(int i = 0; i < 15; i++){
      a = randomX.nextInt(16);
      b = randomX.nextInt(16);
      boardAfter = swap(boardAfter, a, b);
      System.out.println(boardAfter);
    }

    return boardAfter;
  }
}
