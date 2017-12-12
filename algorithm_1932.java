import java.util.*;

class algorithm_1932{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int [][] num_triangle = new int[n+1][n+1];


    for (int i = 1; i < n+1; i++){
      for (int j = 1; j < i+1; j++){
        num_triangle[i][j] = sc.nextInt();
      }
    }
    for (int i = n-1; i >= 1; i--){
      for (int j = 1; j <= i; j++){
        num_triangle[i][j] = num_triangle[i][j] + Math.max(num_triangle[i+1][j], num_triangle[i+1][j+1]);
      }
    }
    System.out.println(num_triangle[1][1]);
  }
}
