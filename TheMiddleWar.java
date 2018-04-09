import java.util.*;

public class TheMiddleWar{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int w = sc.nextInt();
    int [][]war = new int[w*2][7];
    int[] angel = new int[6];
    int[] angel_str = new int[]{1, 2, 3, 3, 4, 10};
    int[] devil = new int[7];
    int[] devil_str = new int[]{1, 2, 2, 2, 3, 5, 10};
    int angel_pow = 0;
    int devil_pow = 0;
    for(int k = 1; k < w + 1; k++){
      for(int i = 0; i < angel.length; i++){
        angel[i] = sc.nextInt();
        angel_pow += angel[i] *angel_str[i];
      }
      for(int j = 0; j < devil.length; j++){
        devil[j] = sc.nextInt();
        devil_pow += devil[j] *devil_str[j];
      }


      if(angel_pow < devil_pow){
        System.out.println("Battle " + k + ": Evil eradicates all trace of Good");
      } else if(angel_pow > devil_pow){
        System.out.println("Battle " + k + ": Good triumphs over Evil");
      } else if(angel_pow == devil_pow){
        System.out.println("Battle " + k + ": No victor on this battle field");
      }
      angel_pow = 0;
      devil_pow = 0;
    }
  }
}

/*Battle 1: Evil eradicates all trace of Good
Battle 2: Good triumphs over Evil
Battle 3: No victor on this battle field*/
/*3 scannner input
1 1 1 1 1 1
1 1 1 1 1 1 1
0 0 0 0 0 10
0 1 1 1 1 0 0
1 0 0 0 0 0
1 0 0 0 0 0 0*/
