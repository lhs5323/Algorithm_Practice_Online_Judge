import java.util.*;

public class FindPath{
  public static int[][] path;
  //public static int[] saved;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    path = new int[n+1][n+1];
    int[][] find_path = new int[n+1][n+1];
    //saved = new int[n+1];
    boolean visted = true;
    for(int i = 1; i < n+1; i++){
      for(int j = 1; j < n+1; j++){
        path[i][j] = sc.nextInt();
      }
    }

    for(int vertex = 1; vertex < n+1; vertex++){
      int[] saved = new int[n+1];
      dfs(vertex, saved, visted);
      for(int i = 1; i < saved.length; i++){
        find_path[vertex][i] = saved[i];
      }
    }
    for(int i = 1; i < find_path.length; i++){
      for(int j = 1; j < find_path[i].length; j++){
        System.out.print(find_path[i][j] + " ");
      }
      System.out.println();
    }
  }
  public static void dfs(int v, int[] saved, boolean check){
    if (!check){
      saved[v] = 1;
    }
    for(int i = 1; i < saved.length; i++){
      if((path[v][i] == 1) && (saved[i] == 0)){
          dfs(i, saved, false);
      }
    }
  }
}
