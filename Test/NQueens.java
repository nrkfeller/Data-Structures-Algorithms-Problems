import java.util.Scanner;

public class NQueens {
 
  static boolean unsafe(int y, int[] remaining) {
    int x = remaining[y];
    for (int i = 1; i <= y; i++) {
      int t = remaining[y - i];
      if (t == x ||
          t == x - i ||
          t == x + i) {
        return true;
      }
    }
 
    return false;
  }
  
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.print("How large do you want the board to be? : ");
    int size = reader.nextInt();
    int[] board = new int[size];
    int possibleSolutions = 0;
    int y = 0;
    board[0] = -1;
    while (y >= 0) {
      do {
        board[y]++;
      } while ((board[y] < board.length && unsafe(y, board)));
      if (board[y] < board.length) {
        if (y < board.length-1) {
          board[++y] = -1;
        } else {
          possibleSolutions++;
        }
      } else {
        y--;
      }
    }
    System.out.println(possibleSolutions);
  }
}