import java.util.*;

class reverse_order{
  //private static List<Integer> my_list;

  public static void main (String[] args){
    Scanner sc = new Scanner(System.in);
    //reverse_order d_order = new reverse_order();
    int n = sc.nextInt();
    int count = 0;
    List<Integer> my_list = new ArrayList<Integer>();
    while(n > 0) {
      my_list.add(n % 10);
      n = n / 10;

    }
    Collections.sort(my_list, Collections.reverseOrder());
    for (int i = 0; i < my_list.size(); i++){
      System.out.print(my_list.get(i));
    }

  }
}
