import java.util.*;

public class Yoot{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    for(int t = 0; t < 3; t++){
      int[] game = new int[4];
      for(int i = 0; i < 4; i++){
        game[i] = sc.nextInt();
      }
      int total = 0;
      for(int i = 0; i < 4; i++){
        total = total + game[i];
      }
      if(total == 1){
        System.out.println('C');
      } else if(total == 2){
        System.out.println('B');
      } else if(total == 3){
        System.out.println('A');
      } else if(total == 4){
        System.out.println('E');
      } else{
        System.out.println('D');
      }
    }


  }
}
