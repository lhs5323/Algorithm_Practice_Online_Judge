import java.util.*;

public class CoinOne{
  public static int k, count;
  public static int[] coin_type;
  public static int[] sum_dp;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    k = sc.nextInt();
    coin_type = new int[n];
    sum_dp = new int[k+1];
    for(int i = 0; i < n; i++){
      coin_type[i] = sc.nextInt();
    }

    sum_dp[0] = 1; count = 0;

    dfs(1, 0);
    /*for(int i = 0; i < n; i++){
      for(int j = 1; j < sum_dp.length; j++){
        if(j - coin_type[i] >= 0)
          sum_dp[j] += sum_dp[j-coin_type[i]] ;
      }
    }*/
    //System.out.println(sum_dp[sum_dp.length-1]);
    System.out.println(count);
  }

  public static void dfs(int index, int value){

    if(index == sum_dp.length){
      if(value == k){
        count++;
      }
      return;
    }
    //sum_dp[index] = value;
    if(index - coin_type[0] >= 0){
      dfs(index+coin_type[0], sum_dp[index] + sum_dp[index - coin_type[0]]);
    }
    if(index - coin_type[1] >= 0){
      dfs(index+coin_type[1], sum_dp[index] + sum_dp[index - coin_type[1]]);
    }
    if(index - coin_type[2] >= 0){
      dfs(index+coin_type[2], sum_dp[index] + sum_dp[index - coin_type[2]]);

    }

  }


}
