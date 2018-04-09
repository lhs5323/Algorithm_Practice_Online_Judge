import java.util.*;

public class RockClimbing{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int t = sc.nextInt();
    List<int[]> position = new ArrayList<int[]>();
    for(int i = 0; i < n; i++){
      for(int j = 0; j < 2; j++){
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] x_y = new int[]{x, y};
        position.add(x_y);
      }
    }
  }
}
