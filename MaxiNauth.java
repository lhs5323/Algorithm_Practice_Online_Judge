import java.util.*;

public class MaxiNauth{
  //public static int[] set_elec = new int[]{{1,0},{-1,0},{0,1},{0,-1}};
  public static int answer = 2^31 -1;
  public static int result = 0;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    //int[] set_elec = new int[]{{1,0},{-1,0},{0,1},{0,-1}};
    for(int k = 0; k < t; k++){
      int core = sc.nextInt();
      int[][] process = new int[core][core];
      int[][] dp = new int[core][core];
      boolean[][] visited = new boolean[core][core];
      for(int i = 0; i < process.length; i++){
        for(int j = 0; j< process[i].legnth; j++){
          process[i][j] = sc.nextInt();
          //dp[i][j] = 0;
          visited[i][j] = false;
        }
      }

      for(int a = 0; a < process.length; a++){
        for(int b = 0; b < process[a].length; b++){
          if(visited[a][b] = false && process[a][b] = 1){
            visited[a][b] = true;
            bfs(a, b)
            int var = 0;
            int temp = result;
            var = temp;
            answer = var + temp;
            result = 0;
          }
        }
      }
    System.out.println("#"+t + answer);
    }
  }

  public static void bfs(int x, int y){
    int ans = 0; int ans_1 = 0; int ans_2 = 0; int ans_3 = 0;
    Queue<int[]> process_q = new LinkedList<int[]>();
    process_q.offer(int[]{x, y});
    int[] st_power = new int[]{x, y};
    while(!process_q.isEmpty()){
      int[] power = process_q.poll();
      while(st_power[0] < process.length){
        int x_pos = power[0] + 1;
        int y_pos = power[1];
        int[] power_up = new int[]{x_pos, y_pos};
        if(process[x_pos][y_pos] == 1 || visited[x_pos][y_pos] == true){
          ans = 0;
          break;
        }
        if(x_pos >= 0 && y_pos >= 0 && x_pos > process.length && y_pos > process.length && process[x_pos][y_pos] != 1 && visited[x_pos][y_pos] = false){
          ans = ans + 1;
          //dp[x_pos][y_pos] = dp[power[0]][power[1]] + 1;
          visited[x_pos][y_pos] = true;
          process_q.offer(int[]{x_pos, y_pos});
        }
      }
      result = get_result(ans);
      while(st_power[0]<=0){
        int x_pos = power[0] - 1;
        int y_pos = power[1];
        int[] power_up = new int[]{x_pos, y_pos};
        if(process[x_pos][y_pos] == 1 || visited[x_pos][y_pos] == true){
          ans_1 = 0;
          break;
        }
        if(x_pos >= 0 && y_pos >= 0 && x_pos > process.length && y_pos > process.length && process[x_pos][y_pos] != 1 && visited[x_pos][y_pos] = false && dp[x_pos][y_pos] == 0){
          //dp[x_pos][y_pos] = dp[power[0]][power[1]] + 1;
          ans_1 = ans_1 + 1;
          visited[x_pos][y_pos] = true;
          process_q.offer(int[]{x_pos, y_pos});
        }
      }
      result = get_result(ans, ans_1);
      while(st_power[1] < process.length){
        int x_pos = power[0];
        int y_pos = power[1] + 1;
        int[] power_up = new int[]{x_pos, y_pos};
        if(process[x_pos][y_pos] == 1 || visited[x_pos][y_pos] == true){
          ans_2 = 0;
          break;
        }
        if(x_pos >= 0 && y_pos >= 0 && x_pos > process.length && y_pos > process.length && process[x_pos][y_pos] != 1 && visited[x_pos][y_pos] = false && dp[x_pos][y_pos] == 0){
          //dp[x_pos][y_pos] = dp[power[0]][power[1]] + 1;
          ans_2 = ans_2 + 1;
          visited[x_pos][y_pos] = true;
          process_q.offer(int[]{x_pos, y_pos});
        }
      }

      result = get_result(result , ans_2);
      while(st_power[1] >= 0){
        int x_pos = power[0];
        int y_pos = power[1] - 1;
        int[] power_up = new int[]{x_pos, y_pos};
        if(process[x_pos][y_pos] == 1 || visited[x_pos][y_pos] == true){
          ans_3 = 0;
          break;
        }
        if(x_pos >= 0 && y_pos >= 0 && x_pos > process.length && y_pos > process.length && process[x_pos][y_pos] != 1 && visited[x_pos][y_pos] = false && dp[x_pos][y_pos] == 0){
          //dp[x_pos][y_pos] = dp[power[0]][power[1]] + 1;
          ans_3 = ans_3 + 1;
          visited[x_pos][y_pos] = true;
          process_q.offer(int[]{x_pos, y_pos});
        }
      }
      result = get_result(result, ans_3);



    }

  }
  public static int get_result(int a, int b){
    int max = 0;
    if(a < b && a != 0){
      max = a;
    } else if (b < a && b != 0){
      max = b;
    } else {
      max = 0;
    }
    return max;
  }
}
