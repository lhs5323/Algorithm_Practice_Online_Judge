import java.util.*;

class algorithm_10817 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a, b, c;
    a = sc.nextInt();
    b = sc.nextInt();
    c = sc.nextInt();

    if (a < b) {
      if (a > c) {
        System.out.println(a);
      } else if (a < c) {
          if (b < c) {
            System.out.println(b);
          } else {
            System.out.println(c);
          }
      }
    } else if (a > b) {
        if (a > c) {
          if (b < c) {
            System.out.println(c);
          } else {
            System.out.println(b);
          }
        } else {
            System.out.println(a);
          }
    } else if (a == b) {
        if (a > c) {
          System.out.println(a);
        } else if (a < c) {
          System.out.println(a);
        } else {
          System.out.println(a);
        }
    } else if (a == c) {
        System.out.println(c);
    } else {
        System.out.println(b);
      }
  }
}
