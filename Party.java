import java.util.*;

public class Party{

  public static int[][] adj_mat;
  public static int n, ith, jth;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    int edge = sc.nextInt();
    int p_house = sc.nextInt();
    adj_mat = new int[n+1][n+1];
    for(int i = 1; i < n+1; i++){
      for (int j = 1; j< n+1; j++){

        if(i == j){
          adj_mat[i][j] = 0;
        } else {
          adj_mat[i][j] = 100001;
        }
      }
    }

    for(int i = 0; i < edge; i++){
        ith = sc.nextInt();
        jth = sc.nextInt();
        adj_mat[ith][jth] = sc.nextInt();
    }
    System.out.println(floyd_warshell(p_house));
  }

  public static int floyd_warshell(int a){
    int max = 0;
    for(int k = 1; k < n+1; k++){
      for(int i = 1; i < n+1; i++){
        for(int j = 1; j< n+1; j++){
          if(adj_mat[i][j] > adj_mat[i][k] + adj_mat[k][j]){
            adj_mat[i][j] = adj_mat[i][k] + adj_mat[k][j];
          }
        }
      }
    }
    for(int x = 1; x < n+1; x++){
      if(adj_mat[x][a] + adj_mat[a][x] > max){
        max = adj_mat[x][a] + adj_mat[a][x];
      }
    }
    return max;
  }
}
