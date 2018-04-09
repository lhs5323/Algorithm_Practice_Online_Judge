import java.util.*;

public class Dice{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] move = new int[n+1];
    int[] dice_ans = new int[m+1];
    int horse = 1;
    int cnt = 0;

    for(int i = 1; i<move.length; i++){
      move[i] = sc.nextInt();
    }
    for(int j = 1; j<dice_ans.length; j++){
      dice_ans[j] = sc.nextInt();
    }

    if (horse == n){
      System.out.println(cnt);
    }
    for(int x = 1; x < m+1; x++){
      cnt ++;
      horse = horse + dice_ans[x];
      if(horse < n+1){
          horse = horse + move[horse];
      }
      if(horse >= n){
        System.out.println(cnt);
        break;
      }
    }
  }
}

/*10 5
0
0
5
6
-3
8
1
8
-4
0
1
3
5
1
5*/
