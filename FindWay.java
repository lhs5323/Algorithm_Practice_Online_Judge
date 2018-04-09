import java.util.*;

public class FindWay{
  public static int graph[][];
  public static int search_one[][];
  public static boolean visted[];
  public static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();

    graph = new int[n+1][n+1];
    for (int i = 1; i < n+1; i++){
      for (int j = 1; j < n+1; j++){
        graph[i][j] = sc.nextInt();
      }
    }
    bfs(graph);
    for(int a = 1; a < n+1; a++){
      for(int b = 1; b < n+1; b++){
        System.out.print(search_one[a][b]);
      }
    }
  }

  public static void bfs(int[][] x){

    Queue<Integer> bfs_q = new LinkedList<Integer>();
    search_one = new int[n+1][n+1];
    visted = new boolean [n+1];

    for(int i = 1; i<n+1; i++){
      for(int j = 1; j< n+1; j++){

        if (x[i][j] == 1 && visted[i] == false) {
          bfs_q.offer(i);
          visted[i] = true;
        }
        int temp;
        while(!bfs_q.isEmpty()){
          temp = bfs_q.poll();
          for(int f = 1; f < n+1; f++){
            if(x[temp][f] == 1 && visted[f] == false){
              bfs_q.offer(f);
              visted[f] = true;
              search_one[temp][f] = 1;
            }
          }

        }

      }
    }
  }



}
