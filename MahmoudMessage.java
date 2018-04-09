import java.util.*;

public class MahmoudMessage{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int m = sc.nextInt();
    String[] words = new String[n];
    int[] cost = new int[n];
    int[][] group = new int[k][n];
    String[] message = new String[m];
    for(int i = 0; i < n; i++){
      String each_word = sc.next();
      words[i] = each_word;
    }
    for(int i = 0; i < cost.length; i++){
      cost[i] = sc.nextInt();
    }
    for(int i = 0; i < k; i++){
      int word = sc.nextInt();
      group[i][0] = word;
      for(int j = 1; j <= word; j++){
        int word_in_g = sc.nextInt();
        group[i][j] = word_in_g;
      }
    }
    for(int i = 0; i < message.length; i++){
      String each_message = sc.next();
      message[i] = each_message;
    }
    int result = 0; int min_cost = Integer.MAX_VALUE;
    for(int i = 0; i < message.length; i++){
      for(int j = 0; j < words.length; j++){
        if (message[i] == words[j]){
          for(int x = 0; x < group.length; x++){
            for(int y = 1; y <= group[x][0]; y++){
              if(j == group[x][y]){
                if(group[x][0] == 1){
                  result = result + cost[group[x][y] - 1];
                } else{
                    if(min_cost < cost[group[x][y] - 1]);
                      min_cost = cost[group[x][y] - 1];
                }
              }
            }
            result = result + min_cost;
          }
        }
      }
    }




    System.out.println(result);
  }
}
