import java.util.*;


class fibonacci {
  public static int count_zero = 0;
  public static int count_one = 0;
  public static void main (String[] args) {
    fibonacci fibo = new fibonacci();
    Scanner sc = new Scanner(System.in);
    int t;
    t = sc.nextInt();
    List<Integer> list_result = new ArrayList<Integer>();
    for (int i = 0; i < t; i++) {
      list_result.add(sc.nextInt());

      //fibo.fibonacci_recursive((Integer)list_result.get(i));
    }
    System.out.println(list_result);
    for (int j = 0; j < list_result.size(); j ++) {
      fibo.fibonacci_recursive((Integer)list_result.get(j));
      System.out.println(count_zero + " " + count_one);
      count_zero = 0;
      count_one = 0;
    }



  }
  public int fibonacci_recursive(int n)  {
    if(n == 0) {
      count_zero++;
      return 0;
    } else if(n == 1){
        count_one ++;
        return 1;
    } else {
        return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
    }
  }
  double fibbonaci(int n) {
    double prev=0d, next=1d, result=0d;
    for (int i = 0; i < n; i++) {
        result=prev+next;
        prev=next;
        next=result;
    }
    return result;
  }
}
