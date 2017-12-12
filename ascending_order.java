import java.util.*;
class ascending_order{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    int[] c = new int[n];
    for (int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }
    c = do_sort(a);
    for (int i : c){
        System.out.println(i);
    }
  }

  public static int[] do_sort(int[] b){
    int largest;
    for (int j = 1; j < b.length; j++){
      for (int x = j; x > 0; x--){
        if (b[j] < b[j-1]){
          largest = b[j];
          b[j] = b[j-1];
          b[j-1] = largest;
          }
        }
      }
    return b;
  }


}
