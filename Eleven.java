import java.util.*;

public class Eleven{
  public static void main(String[] args){
    //Eleven eleven = new Eleven();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] fibo = new int[1001];
    boolean[] check = new boolean[10001];
    for(int i = 1; i < fibo.length; i++){
      fibo[i] = isFibonacci(i);
      check[fibo[i]] = true;
      if (fibo[i] >= n){
        break;
      }
    }
    for(int i = 1; i < n+1; i++){
      if (check[i] == true){
        System.out.print("O");
      } else{
        System.out.print("o");
      }
    }
  }

  public static int isFibonacci(int a){
    int x = 0;
    if (a == 1){
      return 1;
    } else if (a == 2) {
      return 1;
    } else {
      x = isFibonacci(a-2) + isFibonacci(a-1);
      return x;
    }
  }
}
