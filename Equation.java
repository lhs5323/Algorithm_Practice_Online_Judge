import java.util.*;

public class Equation{
  public static int n,max,min,tt;
  public static int[] n_arr;
  public static int[] c;

  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    n_arr = new int[12];
    for (int i = 0; i < n; i++){
      n_arr[i] = sc.nextInt();
    }
    c = new int[4];
    for (int j = 0; j < 4; j++){
      c[j] = sc.nextInt();
    }
    min = 1000000000; max = -1000000000;
    make_equation(1,c[0],c[1],c[2],c[3],n_arr[0]);

    System.out.println(max);
    System.out.println(min);
  }


  static void make_equation(int index, int plus, int minus, int mult, int div, int t){
    //saved_dp = new ArrayList<Integer>();
    if ((index == n)){
      //saved_dp.add(total);  
      max = Math.max(max, t);
      min = Math.min(min, t);
      return;
    }
    if (plus > 0){
      make_equation(index+1, plus-1, minus, mult, div, t + n_arr[index]);
    }
    if(minus > 0){
      make_equation(index+1, plus, minus-1, mult, div, t - n_arr[index]);
    }
    if(mult > 0){
      make_equation(index+1, plus, minus, mult-1, div, t * n_arr[index]);
    }
    if(div > 0){
      make_equation(index+1, plus, minus, mult, div-1, t / n_arr[index]);
    }
  }
}
