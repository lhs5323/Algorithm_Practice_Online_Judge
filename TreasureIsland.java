import java.util.*;

public class TreasureIsland{

  public static boolean[][] visited;
  public static int[][] island;
  public static int[][] dp;
  public static int[][] movement = new int[][]{{1, 0},{-1, 0},{0, 1},{0,-1}};
  public static int ans = 0;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    char land = 'L';
    char water = 'W';
    int row = sc.nextInt();
    int column = sc.nextInt();
    island = new int[row][column];
    visited = new boolean[row][column];
    dp = new int[row][column];
    for(int i =0; i < row; i++){
      for(int j =0; j< column; j++){
        island[i][j] = 0;
        dp[i][j] = 0;
        visited[i][j] = false;
      }
    }
    for(int i = 0; i < row; i++){
      String l_or_w = sc.next();
      int k = 0;
      for(int j = 0; j< column; j++){
        if(l_or_w.charAt(k) == land){
          island[i][j] = 1;
          k++;
        } else{
          island[i][j] = 0;
          k++;
        }
      }
    }
    int cnt_island = 0;
    for(int i = 0; i < row; i++){
      for(int j = 0; j< column; j++){
        if(island[i][j] == 1 && visited[i][j] == false){
          visited[i][j] = true;
          bfs(i, j, row, column);

        }
      }
    }
    System.out.println(ans);
  }
  public static void bfs(int x, int y, int r, int c){
    Queue<int[]>treasure_q = new LinkedList<int[]>();
    treasure_q.offer(new int[]{x, y});
    while(!treasure_q.isEmpty()){
      int[] find_treasure = treasure_q.poll();

      for(int k = 0; k < 4; k++){
        int x_position = find_treasure[0] + movement[k][0];
        int y_position = find_treasure[1] + movement[k][1];
        int[] canbe_treasure = new int[]{x_position, y_position};
        if((x_position >= 0 && y_position >= 0 && x_position < r && y_position < c) && visited[canbe_treasure[0]][canbe_treasure[1]] == false && island[canbe_treasure[0]][canbe_treasure[1]] == 1){
          dp[canbe_treasure[0]][canbe_treasure[1]] = dp[find_treasure[0]][find_treasure[1]] + 1;
          visited[canbe_treasure[0]][canbe_treasure[1]] = true;
          treasure_q.offer(canbe_treasure);
        }
      }
    }
    if(getMinimumPath(r, c) > ans){
      ans = getMinimumPath(r,c);
    }
    for(int i = 0; i < r; i++){
      for(int j = 0; j< c; j++){
        dp[i][j] = 0;
        visited[i][j] = false;
      }
    }
  }

  public static int getMinimumPath(int x, int y){
    int max = 0;
    for(int i = 0; i < x; i++){
      for(int j = 0; j< y; j++){
        if(dp[i][j] > max){
          max = dp[i][j];
        }
      }
    }
    if(max == 1 || max == 0){
      return 0;
    } else{
      return max;
    }
  }
}
