import java.util.*;
class pinary {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    pinary count_pinary = new pinary();
    int n = sc.nextInt();

    System.out.println(count_pinary.fibo(n));

  }
  public double fibo(int n) {
    /*if ( n == 0 ) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return (fibo(n - 1) + fibo(n - 2));
    }*/
    double prev = 0d, next = 1d, result = 0d;
    for (int i = 0; i < n; i++) {
      result = prev + next;
      prev = next;
      next = result;
    }
    return result;
  }
}
