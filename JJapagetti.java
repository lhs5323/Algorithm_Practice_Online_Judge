/******************************************************************************
4012. [모의 SW 역량테스트] 요리사
input variable: t_case(테케), n(재료수), foods[][](각 재료합의 synergy)
main vairable: a_sum,b_sum(부분집합의 synergy), result(최솟값)
문제설명: 두 명의 손님에게 음식을 제공하려고 한다.
두 명의 손님은 식성이 비슷하기 때문에, 최대한 비슷한 맛의 음식을 만들어 내야 한다.
N개의 식재료가 있다.
식재료들을 각각 N / 2개씩 나누어 두 개의 요리를 하려고 한다. (N은 짝수이다.)
이때, 각각의 음식을 A음식, B음식이라고 하자.
비슷한 맛의 음식을 만들기 위해서는 A음식과 B음식의 맛의 차이가 최소가 되도록 재료를 배분해야 한다.
음식의 맛은 음식을 구성하는 식재료들의 조합에 따라 다르게 된다.
식재료 i는 식재료 j와 같이 요리하게 되면 궁합이 잘 맞아 시너지 S[i][j]가 발생한다. (1 ≤ i ≤ N, 1 ≤ j ≤ N, i ≠ j)
각 음식의 맛은 음식을 구성하는 식재료들로부터 발생하는 시너지 S[i][j]들의 합이다.
식재료 i를 식재료 j와 같이 요리하게 되면 발생하는 시너지 S[i][j]의 정보가 주어지고, 가지고 있는 식재료를 이용해 A음식과 B음식을 만들 때, 두 음식 간의 맛의 차이가 최소가 되는 경우를 찾고 그 최솟값을 정답으로 출력하는 프로그램을 작성하라.
접근: 부분집합의 합(dfs로 가능) 근데 비트연산으로도 가능 유사문제 스타크링크(작년 하반기 기출)
******************************************************************************/
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
      }
    }
    for(int i = 0; i < b.size(); i++){
      for(int j = 0; j < b.size(); j++){
        b_sum += foods[b.get(i)][b.get(j)];
      }
    }
    result = Math.min(result, Math.abs(a_sum - b_sum));
  }
  //n/2로 A음식 B음식을 divide
  public static void divide_food(int num){
    result = Integer.MAX_VALUE;
    //부분집합의 갯수는 2^n으로 표기가능하니까 0부터 4를 1<<num만큼 돔
    for(int i = 0; i < (1<<num); i++){
      food_a.clear(); food_b.clear();
      a_sum = 0; b_sum = 0;
      for(int j = 0; j < num; j++){
        /**********************************************************************
        핵심:
        예제 input: 4           i==3
                                j=0   j=1   j=2   j=3
                    0 5 3 8     0011  0011  0011  0011
                    4 0 4 1    &0001 &0010 &0100 &1000
                    2 5 0 3    ----- ----- ----- -----
                    7 2 3 0     0001  0010  0000  0000 food_a{0,1},food_b{2,3}

        **********************************************************************/
        if((i&(1<<j)) != 0){
          food_a.add(j);
        } else{
          food_b.add(j);
        }
      }
      //if food_a && food_b == n/2
      if(food_a.size() == food_b.size()){
        find_synergy(food_a, food_b);
      }
    }
  }
}
