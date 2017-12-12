import java.util.*;
public class algorithm_1002 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc, x1, y1, r1, x2, y2, r2 ;
    Circle c1, c2;
    tc = sc.nextInt();
    x1 = sc.nextInt();
    y1 = sc.nextInt();
    r1 = sc.nextInt();
    x2 = sc.nextInt();
    y2 = sc.nextInt();
    r2 = sc.nextInt();

    c1 = new Circle(x1, y1, r1);
    c2 = new Circle(x2, y2, r2);

    if ( tc == 0 ) {
      System.out.println("Enter the Input");
    } else {
        int count_line = 0;
        if (sc.hasNextLine()) {
          count_line++;
          sc.nextLine();
          if (count_line == tc) {
            get_Circle(c1,c2);
          } else{
            System.out.print("Continue inputing the Integer");
          }
        }
    }
	}

  private static int get_Circle(Circle c1, Circle c2) {
    int result = 0, sum_r = c1.r + c2.r, diff_r = Math.abs(c1.r-c2.r);
    double euc = getEuc(c1,c2);

    if (c1.x == c2.x && c1.y == c2.y) {
      if (c1.r == c2.r) {
        result = -1;
      } else {
        result = 0;
      }
    } else {
      if (sum_r == euc || diff_r == euc) {
        result = 1;
      } else if (sum_r < euc && euc < diff_r) {
        result = 2;
      }
    }
    System.out.println(result);
    return result;
  }

  private static double getEuc(Circle c1, Circle c2) {
    return Math.sqrt(Math.pow(c2.x-c1.x,2) + Math.pow(c2.y-c1.y,2));
  }
}

  class Circle {
    int x, y, r;

    public Circle(int x, int y, int r) {

      this.x = x;
      this.y = y;
      this.r = r;
    }
  }
