import java.util.*;

public class SugarDelivery{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int kilo = sc.nextInt();
    int n = kilo / 5;
    int x = kilo / 3;
    int ans = 0;
    for(int i = 0; i <= n; i++){
      for(int j = 0; j <= x; j++){
        if(i * 5 + 3 * j == kilo){
          ans = j + i;
        }
      }
    }
    if(ans == 0){
      System.out.println(-1);
    } else {
      System.out.println(ans);
    }
  }
}
