import java.util.*;
//import java.util.Arrays;

public class Points{
  //public static int d;
  //public static int min;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int d = sc.nextInt();
    int[] list = new int[n];
    int[] unsort = new int[n];
    int min = 100;
    for(int i = 0; i < n; i++){
      list[i] = sc.nextInt();
      unsort[i] = list[i];
    }
    Arrays.sort(unsort);
    for(int i = 0; i < list.length; i++){
      int temp = list[i];
      for(int j = i + 1; j < list.length; j++){
        if (((list[j] - temp == d) || (temp - list[j] == d))){
            int ans = (i - 0) + ((list.length-1) - j);
            //int[] ans = new int[]{ans, {i, j}};
            if(ans <= min){
              min = ans;
              System.out.println(min);
            }
        }

      }
    }
    if(n == 1 || (unsort[unsort.length - 1] - unsort[0] < d) || (unsort[unsort.length - 1] - unsort[0] == 0 )) {
      System.out.println(0);
    } else if(min == 100 && d != 0){
        multi_set(d - 1, min, list);
    } else if (min != 100){
        System.out.println(min);
    }

  }
  public static void multi_set(int dist, int m, int[] llist){
    for(int i = 0; i < llist.length; i++){
      int temp = llist[i];
      for(int j = i + 1; j < llist.length; j++){
        if (((llist[j] - temp == dist) || (temp - llist[j] == dist)) && dist != 0){
            int ans = (i - 0) + ((llist.length-1) - j);
            //int[] ans = new int[]{ans, {i, j}};
            if(ans <= m){
              m = ans;
            }
        }
      }
    }
    if(m == 100 && dist != 0){
      multi_set(dist - 1, m, llist);
    } else if (m != 100){
      System.out.println(m);
    }
  }
}
