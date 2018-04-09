import java.util.*;

public class subSum{
  public static int n, sum, count;
  public static int[] num;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    sum = sc.nextInt();
    num = new int[n];
    count = 0;
    //boolean[] chk = new boolean[n];
    for(int i = 0; i < n; i++){
      num[i] = sc.nextInt();
    }

    /*for(int i = 0; i < n; i++){
      dfs(i, num[i]);
    }*/
    dfs(0,0);
    System.out.println(count);

  }
  public static void dfs(int now, int value){
    //int value = 0;
    //int index = now;
    //System.out.println(value);
    //System.out.println(now);
    if(now == num.length){
      if(value == sum){
        count++;
        //System.out.println(count);
      //return;
      }
      return;
    }
      dfs(now+1, value + num[now]);
      dfs(now+1, value);





  }

}
