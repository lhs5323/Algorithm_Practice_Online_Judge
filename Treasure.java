import java.io.*;
import java.util.*;

public class Treasure{
	static Node[] data;
	public static void main(String[] args) throws IOException{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(buf.readLine());

		data = new Node[N];
		StringTokenizer str = new StringTokenizer(buf.readLine());
		for(int i=0; i<N; i++)
			data[i] = new Node(Integer.parseInt(str.nextToken()), i);

		for(int i=0; i<N-1; i++){
			StringTokenizer line = new StringTokenizer(buf.readLine());
			int a = Integer.parseInt(line.nextToken()) - 1;
			int b = Integer.parseInt(line.nextToken()) - 1;

			data[a].addChild(data[b]);
			data[b].addChild(data[a]);
		}



		dp = new long[N][2];

		int index =0;
		for(index=0; index<N; index++){
			if(data[index].next.size() != 1){
        System.out.println(data[index].next.size());
				dfs(data[index]);
				break;
			}
		}

		// System.out.println(dp[index][0]+" "+dp[index][1]);
		System.out.println(Math.max(dp[index][0], dp[index][1]));
	}

	static long[][] dp;


	static void dfs(Node now){
		int index = now.num;
    System.out.println("Current index" + index);
		now.visit = true;
		if(now.next.size() == 1){
			dp[index][1] = now.cnt;
			dp[index][0] = 0;
			return;
		}

		for(Node n : now.next){
			if(n.visit == false)
        System.out.println("chkin Node" + n.num);
				dfs(n);
		}

		dp[index][1] = now.cnt;
		for(Node n : now.next){
			dp[index][0] += Math.max(dp[n.num][0], dp[n.num][1]);
			dp[index][1] += dp[n.num][0];
		}
	}



	public static class Node{
		int num;
		int cnt;
		LinkedList<Node> next;
		boolean visit;
		Node(int cnt, int num){
			this.cnt = cnt;
			this.num = num;
			this.next = new LinkedList<Node>();
			visit = false;
		}

		void addChild(Node n){
			next.add(n);
		}
	}
}
