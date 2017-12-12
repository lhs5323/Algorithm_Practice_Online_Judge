import java.util.*;

public class FindPath{
  public static int vertex;
  public static int[][] arr;
  public static int[][] new_arr;
  //public static boolean visted[];

  public static void dfs(int v, int[] visted, boolean isFirst){
    if (!isFirst){
      visted[v] = 1;
    }
    for (int i = 1; i < vertex + 1; i++){
      if (arr[v][i] == 1 && visted[i] == 0){
        dfs(i, visted, false);

      }
    }
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    vertex = sc.nextInt();
    arr = new int[vertex+1][vertex+1];
    new_arr = new int[vertex+1][vertex+1];

    for (int i = 1; i < vertex + 1; i++){
      for (int j = 1; j < vertex + 1; j++){
        arr[i][j] = sc.nextInt();
      }
    }
    for (int i = 1; i < vertex + 1; i++){
      int[] visted = new int[vertex+1];
      dfs(i, visted, true);
      new_arr[i] = visted;
    }
    //bfs(vertex);
    for (int i = 1; i < new_arr.length; i++){
      for (int j = 1; j< new_arr[i].length; j++){
        System.out.print(new_arr[i][j] + " ");
      }
      if (i != new_arr.length -1){
        System.out.println();
      }
    }
  }
    //System.out.print(new_arr);

}
