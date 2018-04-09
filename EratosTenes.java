import java.util.*;

public class EratosTenes{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] sieve = new int[n+1];
    boolean[] chk = new boolean[n+1];
    int count = 0;
    for(int i = 0; i <chk.length; i++){
      chk[i] = false;
    }
    //sieve[count] = 2;
    for(int i = 2; i <= n; i++){
      for(int j = 1; i*j <= n; j++){
        if(chk[i*j] == false){
          chk[i*j] = true;
          //System.out.println(i*j);
          sieve[count] = i*j;
          count++;
          //System.out.println(sieve[count]);
        } else {
          continue;
        }
      }
    }
    System.out.println(sieve[k-1]);
  }

}
