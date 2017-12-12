import java.util.*;
public class FindIsland {
  public static int island[][];
  public static int w, h;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int w = sc.nextInt();
    int h = sc.nextInt();
    //String [] line;
    island = new int [h][w];
    //List<Integer> my_island = new ArrayList<Integer>();
    //while (sc.hasNextLine()){
    if (w == 0 && h == 0) break;
    for (int i = 0; i < h; i++){
        //island[i][0] = Integer.parseInt(sc.next());
        //my_island.add(sc.nextInt());
      for(int j = 0; j < w; j++){
        island[i][j] = sc.nextInt();

      }
    }
    /*int count_land = 0;
    for (int i = 0; i < h; i++){
      for (int j = 0; j < w; j++){
        if (island[i][j] > 0){
            count_land ++;
            //x[i][j] = 0;
            check_island(i, j);
          }
      }
    }*/
    System.out.println(find_land(island, h, w));
    //sc.close();


    //System.out.println(count_land);

  }
  private static boolean check_range(int x, int y){
    return((0 <= x && x < h) && (0 <= y && y < w));
  }


  //check the number of land and save its position to the list
  public static int find_land (int a [][], int x, int y){
    int count_land = 0;
    for (int i = 0; i < x; i++){
      for (int j = 0; j < y; j++){
        if (a[i][j] > 0){
          count_land ++;
          //x[i][j] = 0;
          check_island(i, j);
        }
      }
    }
    return count_land;
  }

  public static void check_island (int x, int y) {
    island[x][y] = 0;
    int[] ax = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] ay = {1, 1, 0, -1, -1, -1, 0, 1};
    int dx, dy;
    for (int i = 0; i < 8; i++){
      dx = x + ax[i]; dy = y + ay[i];
      if (check_range(dx, dy) && island[dx][dy] > 0){
          check_island(dx, dy);
      }

    }
  }
}
