import java.util.*;

public class Survive{
  public static int[][] move = new int[][]{{1,0},{0,1}};
  public static boolean[][] visited;
  public static int[][] map;
  public static int[][] remain_life;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int column = sc.nextInt();
    int row = sc.nextInt();
    int life = sc.nextInt();
    map = new int[column][row];
    remain_life = new int[column][row];
    visited = new boolean[column][row];
    //int[][] route = new int[column][row];

    for(int i = 0; i < column; i++){
      for(int j = 0; j< row; j++){
        map[i][j] = sc.nextInt();
        remain_life[i][j] = 0;
        visited[i][j] = false;

      }
    }
    bfs(0, 0, row, column);
    System.out.println(remain_life[column-1][row-1]);
  }
  public static void bfs(int x, int y, int r, int c){
    Queue<int[]> map_q = new LinkedList<int[]>();
    map_q.offer(new int[]{x, y});
    visited[x][y] = true;
    while(!map_q.isEmpty()){
      int[] now_array = map_q.poll();
      for(int k = 0; k < move.length; k++){
        int x_pos = now_array[0] + move[0][k];
        int y_pos = now_array[1] + move[1][k];
        int[] new_array = new int[]{x_pos, y_pos};
        if(x_pos >= 0 && y_pos >= 0 && x_pos < c && y_pos < r && visited[x_pos][y_pos] == false && remain_life[x_pos][y_pos] >= 0){
          visited[x_pos][y_pos] = true;
          remain_life[x_pos][y_pos] = map[now_array[0]][now_array[1]] + map[new_array[0]][new_array[1]];
          map_q.offer(new_array);
        }
      }
    }

  }

}
