import java.util.*;

public class Knight{
  public static int[][] knight_move;
  public static int n;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    knight_move = new int[][]{{-2, 1},{-1, 2},{1, 2},{2, 1},{2, -1},{1, -2},{-1, -2},{-2, -1}};

    int t = sc.nextInt();

    for(int i = 0; i < t; i++){
      n = sc.nextInt();
      int[][] chess = new int [n][n];
      int[] start_p = new int [2];
      int[] end_p = new int[2];
      boolean[][] visted = new boolean[n][n];
      for(int start = 0; start < start_p.length; start++){
        start_p[start] = sc.nextInt();
      }
      for(int end = 0; end < end_p.length; end++){
        end_p[end] = sc.nextInt();
      }
      for(int a = 0; a < n; a++){
        for(int b = 0; b < n; b++){
            //chess[a][b] == 0;
            if(start_p[0] == a && start_p[1] == b){
              chess[a][b] = 1; visted[a][b] = true;
              bfs(start_p, chess, visted);
              System.out.println(chess[end_p[0]][end_p[1]]-1);
            }

        }
      }

    }
  }
  public static void bfs(int[] current, int[][] chess, boolean[][] visted){
    Queue<int[]> knight_q = new LinkedList<int[]>();
    knight_q.offer(current);
    while(!knight_q.isEmpty()){
      current = knight_q.poll();
      for(int i = 0; i < 8; i++){
        int x_pos = current[0] + knight_move[i][0];
        int y_pos = current[1] + knight_move[i][1];
        int[] new_position = new int[]{x_pos, y_pos};
        if(x_pos >= 0 && x_pos<n && y_pos >= 0 && y_pos<n && visted[x_pos][y_pos] == false && (chess[x_pos][y_pos] == 0 || chess[current[0]][current[1]]+1 < chess[x_pos][y_pos])){
          visted[x_pos][y_pos] = true;
          chess[x_pos][y_pos] = chess[current[0]][current[1]] + 1;
          knight_q.offer(new_position);
        }

      }
    }
  }
}
