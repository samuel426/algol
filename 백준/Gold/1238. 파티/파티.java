import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	private static int M, N, X;
	private static ArrayList<Road>[] graph;
	private static ArrayList<Road>[] reverseGraph;
	private static final int INF = Integer.MAX_VALUE;

	public static class Road implements Comparable<Road>{
		int end;
		int cost;
		
		public Road(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Road o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		String[] line = br.readLine().split(" ");
			
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		X = Integer.parseInt(line[2]);
		graph = new ArrayList[N + 1];
		reverseGraph = new ArrayList[N + 1];
			
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			reverseGraph[i] = new ArrayList<>();
		}
			
		PriorityQueue<Road> roads = new PriorityQueue<>();
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
				
			graph[start].add(new Road(end, cost));
			reverseGraph[end].add(new Road(start, cost));
				
		}
			
		int[] fromX = dijkstra(graph, X);
		int[] toX = dijkstra(reverseGraph, X);
			
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			answer = Math.max(answer, fromX[i] + toX[i]);
		}
		System.out.println(answer);
	
		
	}

	private static int[] dijkstra(ArrayList<Road>[] graph, int start) {
		
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Road> pq = new PriorityQueue<>();
		pq.offer(new Road(start, 0));
		
		while(!pq.isEmpty()) {
			Road cur = pq.poll();
			if(cur.cost > dist[cur.end]) continue;
			
			for(Road next : graph[cur.end]) {
				if(dist[next.end] > cur.cost + next.cost) {
					dist[next.end] = cur.cost + next.cost;
					pq.offer(new Road(next.end, dist[next.end]));
				}
			}
		}
		
		return dist;
	}
}