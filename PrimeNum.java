import java.util.*;

public class PrimeNum{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    boolean[] store = new boolean[m+1];
    for(int i = 0; i <store.length; i++){
      store[i] = false;
      store[1] = true;;
    }
    for(int i = 2; i <= m; i++){
      for(int j = 2; j * i <= m; j++){
        store[i*j] = true;
      }
    }
    for(int i = n; i <= m; i++){
      if(store[i] == false){
        System.out.println(i);
      }
    }
  }
}
