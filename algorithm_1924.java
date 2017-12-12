import java.util.*;
class algorithm_1924{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, y;
        x = sc.nextInt();
        y = sc.nextInt();
        int [] monthly_dates = {31,28,31,30,31,30,31,31,30,31,30,31};
        String [] days = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int count = 0;
        for (int i = 0; i < x; i++) {
          if((i + 1) == x) {
            count += y;
          } else {
            count +=  monthly_dates[i];
          }

        }
        
        System.out.println(days[(count%7)]);
    }
}
