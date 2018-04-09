import java.util.*;

public class Tomato{

  public static int n, m;
  public static int[][] tomato_box;
  public static int[][] make_ripe;
  public static boolean[][] visted;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    m = sc.nextInt();
    n = sc.nextInt();
    tomato_box = new int[n][m];
    visted = new boolean[n][m];
    make_ripe = new int[][]{{-1,0}, {1, 0}, {0, 1}, {0, -1}};
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        tomato_box[i][j] = sc.nextInt();
        visted[i][j] = false;
      }
    }
    for(int a = 0; a < n; a++){
      for(int b = 0; b < m; b++){
        if(tomato_box[a][b] == 1 && visted[a][b] == false){
          visted[a][b] = true;
          bfs(a, b);
        }
      }
    }
    System.out.println(getDays());
  }

  public static void bfs(int x, int y){
    Queue<int[]>tomato_q = new LinkedList<int[]>();
    tomato_q.offer(new int[]{x, y});

    while(!tomato_q.isEmpty()){
      int[] next_ripen_tomato = tomato_q.poll();
      for(int i = 0; i < 4; i ++){
        int x_pos = next_ripen_tomato[0] + make_ripe[i][0];
        int y_pos = next_ripen_tomato[1] + make_ripe[i][1];
        int[] new_ripen_tomato = new int[]{x_pos, y_pos};
        if((x_pos>=0 && x_pos < n && y_pos >= 0 && y_pos < m) && (tomato_box[x_pos][y_pos] == 0 || tomato_box[next_ripen_tomato[0]][next_ripen_tomato[1]] +1 < tomato_box[x_pos][y_pos]) && visted[x_pos][y_pos] == false){
          tomato_q.offer(new_ripen_tomato);
          visted[new_ripen_tomato[0]][new_ripen_tomato[1]] = true;
          tomato_box[x_pos][y_pos] = tomato_box[next_ripen_tomato[0]][next_ripen_tomato[1]] + 1;
        }
      }
    }
    for(int i = 0; i < n; i++){

      for(int j = 0; j< m; j++){
        
        visted[i][j] = false;
      }
    }
  }

  public static int getDays(){
    int max = 0;
    for(int x = 0; x < n; x++){
      for(int y = 0; y < m; y++){
        if(tomato_box[x][y] == 0){
          return -1;
        } else if(max < tomato_box[x][y]){
          max = tomato_box[x][y] - 1;
          }
        }
      }

    return max;
  }

}
