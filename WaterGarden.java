import java.util.*;

public class WaterGarden{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();

    for(int i = 1; i < t+1; i++){
      int bed_num = sc.nextInt();
      int tab_num = sc.nextInt();
      for(int j = 1; j<tab_num+1; j++){
        int[] tab_position = new int[tab_num+1];
        tab_position[j] = sc.nextInt();
      }
      for(int a = 1; a<bed_num+1; a++){
        int[] garden = new int[bed_num+1];
        if(a == tab_position[a]){
          garden[a] = 1;
        } else {
          garden[a] = 0;
        }
      }
      int cnt = 0;
      if(all_tabbed(garden, bed_num) == true){
        System.out.println(cnt);
      } else {
        while(all_tabbed(garden, bed_num) == true){
          for(int x = 1; x < tab_position.length+1; x++){
            if((garden[tab_position[x] - 1] == 0) && (garden[tab_position[x]+1] == 0) && (tab_position[x] - 1 > 0) && (tab_position[x] + 1 < bed_num)){
              garden[tab_position[x] - 1] = 1;
              garden[tab_position[x] + 1] = 1;
              cnt++;
            }

          }
        }
      }
    }
  }
  public static boolean all_tabbed(int[] w_garden, int n_bed){
    for(int i = 1; i < n_bed+1; i++){
      if(w_garden[i] == 1){
        return true;
      } else {
        return false;
      }
    }
  }
}
