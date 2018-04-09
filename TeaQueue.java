import java.util.*;

public class TeaQueue{
  public static int num_ppl;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    for(int k = 1; k <= t; k ++){
      num_ppl = 0;
      num_ppl = sc.nextInt();
      int[][] sec = new int[t+1][num_ppl+1];
      int[][] wait = new int[t+1][num_ppl+1];

      for(int i = 1; i < num_ppl+1; i++){
        sec[k][i] = sc.nextInt();
        wait[k][i] = sc.nextInt();

      }
      //int count = sec[k][1];
      for(int j = 1; j < num_ppl+1; j++){
        int count = sec[k][j];
        if(sec[k][j] <= wait[k][j] && count <= wait[k][j]){
          System.out.print(count + " ");
          count++;
        } else if (count > wait[k][j]){
          System.out.print(0 + " ");
        }
      }
    }
  }
}
