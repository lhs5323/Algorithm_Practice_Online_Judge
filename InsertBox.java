import java.util.*;

public class InsertBox{
  public static int n, result;
  public static int[] box;
  public static int[] newBox;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    box = new int[n];
    newBox = new int[n];

    for(int i = 0; i < n; i++){
      box[i] = sc.nextInt();
    }
    //int result = 0;
    for(int i = 0; i < n; i++){
      //result = 0;
      newBox[i] = box[i];
      iterate(i, newBox);
      for(int j = 0; j < n; j++){
        newBox[j] = 0;
      }
    }
  }

    public static void iterate(int a, int[] new_box){
      //int max = max_lis; int result = 0;
      for(int i = a+1; i < n  ; i++){
        //int max = 0;
        if(box[a] < box[i]){
          new_box[a + 1] = box[i];
          a = i;
          iterate(a, new_box);
        }
      }
      for(int j = 0; j< n ; j++){
        System.out.print(new_box[j]);

      }
      System.out.println();

    }


}
