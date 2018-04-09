import java.util.*;

public class Stair{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] stair_w = new int[n];
    int[] dp = new int[n];
    for(int i = 0; i < n; i++){
      stair_w[i] = sc.nextInt();
    }

    if(n == 1){
      System.out.println(stair_w[0]);
    } else if(n == 2){
      System.out.println(stair_w[0] + stair_w[1]);
    } else if(n == 3){
      System.out.println(Math.max(stair_w[1] + stair_w[2], stair_w[0] + stair_w[2]));
    } else {
      dp[0] = stair_w[0];
      dp[1] = stair_w[0] + stair_w[1];
      dp[2] = Math.max(stair_w[1] + stair_w[2], stair_w[0] + stair_w[2]);
      for(int i = 3; i < n; i++){
        dp[i] = Math.max(dp[i-3] + stair_w[i-1] + stair_w[i], dp[i-2] + stair_w[i]);
        //System.out.println(dp[i]);
      }
    }

    System.out.println(dp[n-1]);

  }
}
