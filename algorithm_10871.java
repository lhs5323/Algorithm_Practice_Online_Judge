import java.util.*;
class algorithm_10871 {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, x;
    n = sc.nextInt();
    x = sc.nextInt();
    int [] arr_n = new int[n];
    List<Integer> list_result = new ArrayList<Integer>();
    //int [] arr_x = new int[x];
    for (int i = 0; i < n; i++) {
      arr_n[i] = sc.nextInt();
      if (arr_n[i] < x) {
          list_result.add(arr_n[i]);

        }
      }

    for (int i = 0; i < list_result.size(); i ++) {
      System.out.println((Integer)list_result.get(i) + " ");

    }
  }
}
