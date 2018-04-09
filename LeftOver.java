import java.util.*;

public class LeftOver{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int total = 1000;
    int price = sc.nextInt();
    int leftover = total - price;
    int[] payback = new int[]{500, 100, 50, 10, 5, 1};
    int count = 0;

    for(int i = 0; i < payback.length; i++){
      while(leftover > 0){
        if(leftover >= payback[i]){
          leftover = leftover - payback[i];
          count++;
        }
        if(leftover < payback[i]){
          break;
        }
      }
    }
    System.out.println(count);
  }
}
