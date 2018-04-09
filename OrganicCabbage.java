import java.util.*;

public class OrganicCabbage{
  public static int[][] worm = new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1}};
  public static boolean[][] visted;
  public static int[][] farm;
  public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   int t = sc.nextInt();

   for(int test = 0; test < t; test++){
     int column = sc.nextInt();
     int row = sc.nextInt();
     int cabbage_num = sc.nextInt();
     farm = new int[column][row];
     visted = new boolean[column][row];
     int count = 0;
     for(int i = 0; i < column; i++){
       for(int j = 0; j < row; j++){
         farm[i][j] = 0;
         visted[i][j] = false;
       }
     }
     for(int x = 0; x < cabbage_num; x++){
       int a = sc.nextInt();
       int b = sc.nextInt();
       farm[a][b] = 1;
     }
     for(int i = 0; i < column; i++){
       for(int j = 0; j < row; j++){
         if(farm[i][j] == 1 && visted[i][j] == false){
           dfs(i, j, column, row);
           count++;
         }
       }
     }
     System.out.println(count);
    }
  }
  public static void dfs(int x, int y, int c, int r){
    Queue<int[]>cabbage_q = new LinkedList<int[]>();
    visted[x][y] = true;

    cabbage_q.offer(new int[]{x, y});

    while(!cabbage_q.isEmpty()){
      int[] cabbage_worm = cabbage_q.poll();

      for(int i = 0; i < 4; i ++){
        int x_position = cabbage_worm[0] + worm[i][0];
        int y_position = cabbage_worm[1] + worm[i][1];
        int[] worm_move = new int[]{x_position, y_position};
        if(x_position >= 0 && x_position < c && y_position >= 0 && y_position < r && visted[worm_move[0]][worm_move[1]] == false && farm[worm_move[0]][worm_move[1]] == 1){
          visted[worm_move[0]][worm_move[1]] = true;
          cabbage_q.offer(worm_move);
        }
      }
    }
  }
}
