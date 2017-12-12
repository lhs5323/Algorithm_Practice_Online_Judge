import java.util.*;

class find_treasure{
  public static void main (String[] args){
    Scanner sc = new Scanner(System.in);
    int n;
    n = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];

    for (int i = 0; i < n; i++){
      a[i] = Integer.parseInt(sc.next());
    }

    for (int j = 0; j < n; j++){
      b[j] = Integer.parseInt(sc.next());
    }

    Arrays.sort(a);
    Arrays.sort(b);
    int sum = 0;
    for (int x = 0; x < n; x++){
      sum += a[x] * b[n-x-1];
    }

    System.out.println(sum);
  }



}
