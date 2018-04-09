import java.util.*;

public class EvenOdd{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    if(k == 1){
      System.out.println("Ehab");
    } else if((k & 1) != 1){
      System.out.println("Mahmoud");
    } else{
      System.out.println("Ehab");
    }


  }
}
