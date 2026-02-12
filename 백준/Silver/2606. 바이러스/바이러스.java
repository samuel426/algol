import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	private static int coms, edges;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		coms = Integer.parseInt(br.readLine());
		edges = Integer.parseInt(br.readLine());
		
		List<Integer>[] adj = new ArrayList[coms+1];
		
		for(int i = 1; i <= coms; i++) adj[i] = new ArrayList<>();
		
		for(int i = 0; i < edges; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			adj[a].add(b);
			adj[b].add(a);
			
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[coms+1];
		
		visited[1] = true;
		q.add(1);
		int answer = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int nxt : adj[cur]) {
				if(!visited[nxt]) {
					answer++;
					visited[nxt] = true;
					q.add(nxt);
				}
			}
		}
		
		System.out.println(answer);
		
	}
}
