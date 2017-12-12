import java.util.*;

class make_one{

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    make_one dp = new make_one();
    int n = sc.nextInt();
    // Base case
    //int [] arr_n = new int [n + 1];

    System.out.println(dp.makeone(n));

  }
  public static int makeone(int n) {
    int [] arr_n = new int [n + 1];
    if (n == 1){
      arr_n[1] = 0;
    } else if (n == 2){
      arr_n[2] = 1;
    } else if (n > 2){
      arr_n[2] = 1;
      arr_n[3] = 1;
    }
    for (int i = 4; i < arr_n.length; i++) {
      arr_n[i] = arr_n[i-1] +1;
      //System.out.println(arr_n[i]);
      if ((i % 3 == 0) && (arr_n[i] > arr_n[i/3] + 1)) {
        arr_n[i] = arr_n[i/3] + 1;
      }
      if ((i % 2 == 0) && (arr_n[i] > arr_n[i/2] + 1)) {
        arr_n[i] = arr_n[i/2] + 1;
      }
    }
    return(arr_n[n]);
  }

}
