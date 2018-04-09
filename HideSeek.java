import java.util.*;

public class HideSeek{
     public static final int MAX_RANGE = 100000;

     public static void main(String[] args){

       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       System.out.println(find_point(n,m));

     }

     public static int find_point(int n, int m){
       if (n < 0 || n > MAX_RANGE || m < 0 || m > MAX_RANGE){
         return -1;
       }
       Queue<Integer> q = new LinkedList<Integer>();
       int[] d = new int[MAX_RANGE + 1];
       int result = -1;

       q.add(n);
       while(!q.isEmpty()) {
         int now = q.remove();
         if(now == m) {
           result = d[now];
           break;
         }
         int[] child_array = new int[]{now - 1, now + 1, now * 2};
         for(int child : child_array) {
           if(child >= 0 && child <= MAX_RANGE && d[child] == 0) {
             q.add(child);
             d[child] = d[now] + 1;
           }
         }
       }
       return result;
     }
}
