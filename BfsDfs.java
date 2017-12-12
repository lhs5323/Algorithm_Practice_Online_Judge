import java.util.*;

public class BfsDfs {
  public static int vertex, edge, start_p;
  public static int[][] graph;
  public static boolean visted [];

  public static void dfs(int v){
    visted[v] = true;
    System.out.print(v+ " ");
    for (int j = 1; j <= vertex; j++){
      if (graph[v][j] == 1 && visted[j] == false){
        dfs(j);
      }

    }

  }
  public static void bfs(int v){
    
  }

  public static void main (String[] args){
    Scanner sc = new Scanner(System.in);

    vertex = sc.nextInt();
    edge = sc.nextInt();
    start_p = sc.nextInt();
    graph = new int[1001][1001];
    visted = new boolean[10001];
    int a, b;
    for(int i = 1; i < edge + 1; i++){
        a = sc.nextInt();
        b = sc.nextInt();

        graph[a][b] = graph[b][a] = 1;
    }
    dfs(start_p);
    System.out.println();
  }
}
