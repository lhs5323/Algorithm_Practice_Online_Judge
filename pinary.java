import java.util.*;
import java.math.BigInteger;

public class pinary {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    BigInteger[] pinary_arr = new BigInteger[n+1];
    if(n == 0) {
      pinary_arr[0] = BigInteger.ZERO;
    }
    if(n == 1){
      pinary_arr[1] = BigInteger.ONE;
    }
    if(n == 2){
      pinary_arr[2] = BigInteger.ONE;
    }
    for(int i = 3; i < n+1; i++){
      pinary_arr[0] = BigInteger.ZERO;
      pinary_arr[1] = BigInteger.ONE;
      pinary_arr[2] = BigInteger.ONE;
      pinary_arr[i] = pinary_arr[i - 1].add(pinary_arr[i -2]);
    }
    System.out.println(pinary_arr[n]);
    sc.close();
  }
}
