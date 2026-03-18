import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static int V, E;
	public static ArrayList<Node>[] graph;
	public static int[] dist;
	public static final int INF = Integer.MAX_VALUE;
	
	public static class Node implements Comparable<Node> {
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        dist = new int[V+1];
        
        for(int i = 1; i <= V; i++) {
        	graph[i] = new ArrayList<>();
        }
        Arrays.fill(dist, INF);
        
        for(int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	graph[u].add(new Node(v, w));
        }
        
        dijkstra(start);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++) {
        	if(dist[i] == INF) {
        		sb.append("INF").append("\n");
        	} else {
        		sb.append(dist[i]).append("\n");
        	}
        }
        System.out.println(sb);
        
    }
    
    public static void dijkstra(int start) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	dist[start] = 0;
    	pq.offer(new Node(start, 0));
    	
    	while(!pq.isEmpty()) {
    		Node cur = pq.poll();
    		int now = cur.vertex;
    		int cost = cur.weight;
    		
    		if(dist[now] < cost) continue;
    		
    		for(Node next : graph[now]) {
    			if(dist[next.vertex] > cost + next.weight) {
    				dist[next.vertex] = cost + next.weight;
    				pq.offer(new Node(next.vertex, dist[next.vertex]));
    				
    			}
    		}
    	}
    }
	
}
