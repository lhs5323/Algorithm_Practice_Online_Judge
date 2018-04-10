import java.util.*;

public class JJapagetti{
  public static int a_sum, b_sum, result;
  public static int[][] foods;
  public static List<Integer> food_a = new ArrayList<Integer>();
  public static List<Integer> food_b = new ArrayList<Integer>();
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t_case = sc.nextInt();
    for(int t = 1; t <= t_case; t++){
      int n = sc.nextInt();
      foods = new int[n][n];
      for(int i = 0; i < foods.length; i++){
        for(int j = 0; j < foods[0].length; j++){
          foods[i][j] = sc.nextInt();
        }
      }
      divide_food(n);
      System.out.println("#" + t + " " + result);
    }
  }
  public static void find_synergy(List<Integer> a, List<Integer> b){
    for(int i = 0; i < a.size(); i++){
      for(int j = 0; j < a.size(); j++){
        a_sum += foods[a.get(i)][a.get(j)];
        //System.out.println(a_sum);
      }
    }
    for(int i = 0; i < b.size(); i++){
      for(int j = 0; j < b.size(); j++){
        b_sum += foods[b.get(i)][b.get(j)];
      }
    }
    //System.out.println(result);
    result = Math.min(result, Math.abs(a_sum - b_sum));

    //System.out.println(result);
  }
  public static void divide_food(int num){
    result = Integer.MAX_VALUE;
    for(int i = 0; i < (1<<num); i++){
      food_a.clear(); food_b.clear();
      a_sum = 0; b_sum = 0;
      for(int j = 0; j < num; j++){
        if((i&(1<<j)) != 0){
          food_a.add(j);
        } else{
          food_b.add(j);
        }
      }
      if(food_a.size() == food_b.size()){
        //System.out.println(food_a);
        //System.out.println(food_b);
        find_synergy(food_a, food_b);
      }
    }
  }
}
