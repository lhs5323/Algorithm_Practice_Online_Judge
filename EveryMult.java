import java.util.*;

public class EveryMult{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long sum = 0;
    int[] num = new int[n];

    for (int i = 0; i < num.length; i++){
      num[i] = sc.nextInt();
    }
    for(int i = 0; i < num.length; i++){
      for(int j= i+1; j< num.length; j++){
        sum = sum + (num[i] * num[j]);
        System.out.println(sum);
      }
    }
    System.out.println(sum);
  }
}
