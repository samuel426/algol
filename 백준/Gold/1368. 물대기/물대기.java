import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Edge> edges = new ArrayList<>();
		
		// 0번 정점과 연결되는 우물 비용
		for(int i = 1; i <= N; i++) {
			int wellCost = Integer.parseInt(br.readLine());
			edges.add(new Edge(0, i, wellCost));
		}
		
		// 논끼리 연결하는 수로 비용
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if(i < j) { // 중복방지
					edges.add(new Edge(i, j, cost));
				}
			}
		}
		Collections.sort(edges);
		
		parent = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		int answer = 0;
		int count = 0;
		
		for(Edge e : edges) {
			if(union(e.from, e.to)) {
				answer += e.cost;
				count++;
				
				// 0번 포함 정점 수가 N+1개 -> MST 간선 수는 N ro
				if(count == N) break;
			}
		}
		System.out.println(answer);
	}
	
	static class Edge implements Comparable<Edge> {
		int from, to, cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	static int[] parent;
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		if(ra == rb) return false;
		parent[rb] = ra;
		return true;
	}

}
