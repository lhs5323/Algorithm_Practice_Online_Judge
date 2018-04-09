import java.util.*;

public class Maze{
  public static int n, m;
  public static int[][] maze;
  public static int[][] position;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    maze = new int[n+1][m+1];
    position = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    for(int i = 1; i < n+1; i++){
      String maze_input = sc.next();
      for(int j = 1; j < m+1; j++){
        //System.out.println(maze_input.charAt(j-1));
        maze[i][j] = maze_input.charAt(j-1) - '0';
      }
    }
    bfs(1, 1);
  }

  public static void bfs(int x, int y){
    Queue<int[]> maze_q = new LinkedList<int[]>();
    maze_q.offer(new int[]{x, y});
    while(!maze_q.isEmpty()){
      int[] current_pos = maze_q.poll();
      for(int i = 0; i < 4; i++){
        int pos_x = current_pos[0] + position[i][0];
        int pos_y = current_pos[1] + position[i][1];
        int[] new_pos = new int[]{pos_x, pos_y};
        if(pos_x >= 0 && pos_y >= 0 && pos_x <= n && pos_y <= m && maze[pos_x][pos_y] == 1){
          maze_q.offer(new_pos);
          maze[pos_x][pos_y] = maze[current_pos[0]][current_pos[1]] + 1;
        }
      }
    }
    System.out.println(maze[n][m]);
  }
}
