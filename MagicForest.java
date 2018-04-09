import java.util.*;

public class MagicForest{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int count= 0;
    for(int i = 1; i <= n; i++){
      for(int j = i; j <= n; j++){
        for(int k = j; k <= n; k++){
          if((((i^j)^k) == 0) && (i+j > k)){
            count++;
          }
        }
      }
    }
    System.out.println(count);
  }
}
