import java.util.*;

public class NthFibo{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] fibo = new int[n+1];
    if (n == 0){
      System.out.println(0);
    } else if(n == 1){
      System.out.println(1);

    } else {
      fibo[0] = 0;
      fibo[1] = 1;
      for(int i = 2; i < n+1; i ++){
        fibo[i] = fibo[i-2] + fibo[i-1];

      }
      System.out.println(fibo[n]);
    }
  }
}
