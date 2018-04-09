import java.util.*;
import java.util.Random;

public class ConsecutiveNum{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<Integer> list_result = new ArrayList<Integer>();
    int random = 60;//randInt(1, 30001);
    int first_int = n;
    int random_num = random;
    list_result.add(first_int);
    list_result.add(random_num);
    int add_ans = first_int-random_num;
    list_result.add(add_ans);
    while(add_ans >= 0){
      int temp = random_num;
      random_num = first_int - temp;
      first_int = temp;
      add_ans = first_int - random_num;
      list_result.add(add_ans);

    }
    System.out.println(list_result.size()-1);
    for(int i = 0; i < list_result.size()-1; i++){
      System.out.print(list_result.get(i) + " ");
    }
  }


  public static int randInt(int min, int max) {
    Random rand = new Random();

    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
  }
}
