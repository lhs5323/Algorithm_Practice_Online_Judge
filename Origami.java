import java.util.*;

public class Origami{
  public static int[][] ori;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    ori = new int[102][102];
    int n = sc.nextInt();
    for(int i = 1; i < n+1; i++){
      int width = sc.nextInt();
      int height = sc.nextInt();
      int width_size = sc.nextInt();
      int height_size = sc.nextInt();
      find_ori(width, height, width_size, height_size, i);
    }
    for(int j = 1; j < n+1; j++){
      System.out.println(find_size(j));
    }
  }
  public static void find_ori(int w, int h, int ws, int hs, int index){
    int[][] origam = new int[ws+w][hs+h];
    for(int i = w; i < w + ws; i++){
      for(int j = h; j < h + hs; j++){
        origam[i][j] = index;
        ori[i][j] = origam[i][j];  

        //System.out.println(ori[i][j]);
      }
    }
  }

  public static int find_size(int test){
    int count = 0;
    for(int a = 0; a < ori.length; a++){
      for(int b = 0; b < ori.length; b++){
        if(ori[a][b] == test){
          count += 1;
        }
      }
    }
    return count;
  }
}
