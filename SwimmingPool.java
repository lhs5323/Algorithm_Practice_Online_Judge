import java.util.*;

public class SwimmingPool{
  public static int[] price;
  public static int[] plan;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t_case = sc.nextInt();
    for(int t = 1; t <= t_case; t++){
      price = new int[4];
      for(int i = 0; i < price.length; i++){
        price[i] = sc.nextInt();
      }
      plan = new int[12];
      for(int j = 0; j < plan.length; j++){
        plan[j] = sc.nextInt();
      }
      int[] dp = new int[12];
      dp[0] = Math.min(price[0] * plan[9], price[1]);
      dp[1] = Math.min(price[0] * plan[10], price[1]) + dp[0];
      dp[2] = Math.min(Math.min(price[0] * plan[11], price[1]) + dp[1], price[2]);
      for(int i = 3; i < dp.length; i++){
        dp[i] = Math.min(Math.min(price[0]*plan[i-3], price[1]) + dp[i-1], dp[i-3] + price[2]);

      }
      for(int i = 0; i < dp.length; i++){
        System.out.print(dp[i] + " ");
      }
      int result = dp[dp.length-1];
      if(result > price[3]){
        result = price[3];
      }
      System.out.println("#" + t + " " + result);
    }

  }
}
