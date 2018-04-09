//노드를 두개가 주어졌을때 첫번째 공통 조상을 찾는 알고리즘을 구축하라

import java.util.*;

public class Binary_Tree{
  public static int graph[][];
  public static int search_one[][];
  public static boolean visted[];

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for (int i = 1; i < n+1; i++){
      for (int j = 1; j < n+1; j++){
        graph[i][j] = sc.nextInt();
      }
    }
    bfs(graph);
    
  }

  public static void bfs(int[][] x){

    Queue<Integer> bfs_q = LinkedList<Integer>();
    for(int i = 1; i<x.length+1; i++){
      for(int j = 1; j< x.length+1; j++){

        if (x[i][j] == 1 && visted[i] == false) {
          bfs_q.offer(i);
          visted[i] == true;
        }
        int temp;
        while(!bfs_q.isEmpty()){
          temp = bfs_q.poll();
          for(int f = 1; f < x.length+1; f++){
            if(graph[temp][f] == 1 && visted[f] == false){
              bfs_q.offer(f);
              visted[f] = true;
              search_one[temp][f] = search_one[f][temp] = 1;
            }
          }

        }

      }
    }
    System.out.print(search_one);
  }



}
