import java.util.*;

public class NQueen{
  public static int[][] chess;
  public static boolean[][] check;
  public static int count;
  //public static int[][] move = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t_case = sc.nextInt();
    for(int i = 1; i <= t_case; i++){
      int n = sc.nextInt();
      count = 0;
      chess = new int[n][n];
      check = new boolean[n][n];
      for(int a = 0; a < chess.length; a++){
        for(int b = 0; b < chess[0].length; b++){
          chess[a][b] = 0;
          check[a][b] = false;
        }
      }
      int[] queen_p = new int[]{0,0};
      dfs(queen_p, 0);
      System.out.println("#" + i + " " + count);

    }

  }
  public static void dfs(int[] now_queen, int length){
    if(now_queen[0] == chess.length){
      count++;
      return;
    }
    for(int i = 0; i < chess.length; i++){
      if(check[now_queen[0]][i] == false && possible(chess, check, now_queen) == true){
        check[now_queen[0]][i] = true;
        chess[now_queen[0]][i] = 1;
        now_queen = new int[]{now_queen[0] + 1, i};
        dfs(now_queen, length+1);
        check[now_queen[0]-1][i] = false;
        chess[now_queen[0]][i] = 0;
      }
    }
  }

  public static boolean possible(int[][] chess_board, boolean[][]check_board, int[] curr_q){
    int n = chess_board.length-1;
    int[][] move = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
    int[][] curr_move = new int[][]{{curr_q[0],n}, {curr_q[0], 0}, {n, curr_q[1]}, {0, curr_q[1]}, {n,n}, {0,0}, {n,0}, {0,n}};
    int[] new_q = new int[]{curr_q[0], curr_q[1]};
    for(int i = 0; i < move.length; i++){
      while(new_q[0] == curr_move[i][0] && new_q[1] == curr_move[i][1]){
        new_q[0] = new_q[0] + move[i][0];
        new_q[1] = new_q[1] + move[i][0];
        if(chess_board[new_q[0]][new_q[1]] != 0){
          return false;
        }
      }
    }
    return true;
  }
}
