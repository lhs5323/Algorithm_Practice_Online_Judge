import java.util.*;

public class Snail{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int day = sc.nextInt();
    int night = sc.nextInt();
    int tree = sc.nextInt();

    int now = 0;
    int count = 0;

    while(now != tree){
      now = now + day;
      count++;
      if(now >= tree){
        break;
      }
      now = now - night;

    }
    System.out.println(count);
  }
}
