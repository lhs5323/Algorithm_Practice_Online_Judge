import java.util.*;

public class BaseballGame{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] gemenis = new int[9+1];
    int[] stark = new int[9+1];

    for(int i = 1; i < gemenis.length; i++){
      gemenis[i] = sc.nextInt();
    }
    for(int j = 1; j < stark.length; j++){
      stark[j] = sc.nextInt();
    }

    int cnt = 0; int score_g = 0; int score_s = 0;
    for(int x = 1; x < 10; x++){
      score_g += gemenis[x];
      if(score_g > score_s){
        cnt++;
        score_s += stark[x];
      } else {
        score_s += stark[x];
      }
    }
    if((cnt > 0) && (score_s > score_g)){

      System.out.println("Yes");
    } else{
      System.out.println("No");
    }
  }
}
