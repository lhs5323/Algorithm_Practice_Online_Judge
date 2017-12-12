import java.util.*;
import java.math.*;

class algorithm_11720 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n;
    n = sc.nextInt();
    BigInteger x = sc.nextBigInteger();
    BigInteger sum = new BigInteger("0"); BigInteger number = new BigInteger("0");
    if (n == 0){
      System.out.println(0);
    } else {
      for (int i = 0; i < n; i++) {
        number = x.mod(BigInteger.valueOf(10));
        x = x.divide(BigInteger.valueOf(10));
        sum = sum.add(number);
      }
    }

    System.out.println(sum);
  }
}
