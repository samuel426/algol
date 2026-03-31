import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static class Node implements Comparable<Node> {
		int to;
		int cost;
		
		Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost; // 비용 기준 오름차순
		}
		
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<Node>[] graph = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[start].add(new Node(end, cost));
			
		}
		
		st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[n + 1];
		int[] prev = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		
		for(int i = 1; i <= n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[startCity] = 0;
		pq.offer(new Node(startCity, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.to]) continue;
			visited[cur.to] = true;
			
			for(Node next : graph[cur.to]) {
				if(dist[next.to] > dist[cur.to] + next.cost) {
					dist[next.to] = dist[cur.to] + next.cost;
					prev[next.to] = cur.to;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
		
		Stack<Integer> path = new Stack<>();
		int cur = endCity;
		
		while(cur != 0) {
			path.push(cur);
			cur = prev[cur];
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(dist[endCity]).append("\n");
		sb.append(path.size()).append("\n");
		
		while(!path.isEmpty()) {
			sb.append(path.pop()).append(" ");
		}
		
		System.out.println(sb);
	}
}
