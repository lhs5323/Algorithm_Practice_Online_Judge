import java.util.*;

public class JJapagettiTwo{
  public static int a_sum, b_sum, result, n, diff;
  public static int[][] foods;
  public static boolean[] visited;

  public static int min;
  public static List<Integer> food_a = new ArrayList<Integer>();
  public static List<Integer> food_b = new ArrayList<Integer>();
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t_case = sc.nextInt();
    for(int t = 1; t <= t_case; t++){
      n = sc.nextInt();
      foods = new int[n][n];
      min = Integer.MAX_VALUE;
      for(int i = 0; i < foods.length; i++){
        for(int j = 0; j < foods[0].length; j++){
          foods[i][j] = sc.nextInt();
        }
      }
      visited = new boolean[n+1];
      divide_food(0, 1);
      System.out.println("#" + t + " " + min);
    }
  }
  public static void divide_food(int start, int end){
    visited[start] = true;
    if(n/2 == end){
      get_food();
    } else {
      for(int i = start+1; i < n; i++){
        if(visited[i] == false){
          visited[i] = true;
          divide_food(i, end+1);
        }
      }
    }
    visited[start] = false;
  }
  public static void get_food(){
    food_a = new ArrayList<Integer>();
    food_b = new ArrayList<Integer>();
    //int a_index = 1, b_index = 1;
    for (int i = 0; i < n; i++) {
        if (visited[i] == true) {
            food_a.add(i);
        } else {
            food_b.add(i);
        }
    }
    int a_sum = get_synergy(food_a);
    int b_sum = get_synergy(food_b);
    diff = Math.abs(a_sum - b_sum);
    if(diff < min){
      min = diff;
    }
    System.out.println(result);
    food_a.clear(); food_b.clear();
    a_sum = 0; b_sum = 0;
  }
  public static int get_synergy(List<Integer> food_arr){
    result = 0;
    for(int i = 0; i < food_arr.size(); i++){
      for(int j = 0; j < food_arr.size(); j++){
        result += foods[food_arr.get(i)][food_arr.get(j)];
      }
    }
    return result;
  }
}
