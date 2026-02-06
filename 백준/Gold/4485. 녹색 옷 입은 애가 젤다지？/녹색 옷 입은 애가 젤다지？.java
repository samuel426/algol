import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	private static int SIZE, CAVE[][];
	private static int[] dirx = {0, 0, 1, -1};
	private static int[] diry = {1, -1, 0, 0};	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int pm = 1;
		while(true) {
			
			SIZE = Integer.parseInt(br.readLine());
			if(SIZE == 0) break;
			CAVE = new int[SIZE][SIZE];
			for(int i = 0; i < SIZE; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < SIZE; j++) {
					CAVE[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = dijkstra();
			
			
			System.out.println("Problem " + pm++ + ": " + answer);
		}
		
		
		
		
		
	}
	private static int dijkstra() {
		int[][] dist = new int[SIZE][SIZE];
		for(int i = 0; i < SIZE; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		
		dist[0][0] = CAVE[0][0];
		pq.offer(new int[] {0, 0, dist[0][0]});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int x = cur[0];
			int y = cur[1];
			int cost = cur[2];
			if(cost > dist[x][y]) continue;
			
			if(x == SIZE -1 && y == SIZE - 1) return cost;
			
			for(int k = 0; k < 4; k++) {
				int nx = x + dirx[k];
				int ny = y + diry[k];
				if(nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE) continue;
				
				int ncost = cost + CAVE[nx][ny];
				if(dist[nx][ny] > ncost) {
					dist[nx][ny] = ncost;
					pq.offer(new int[] {nx, ny, ncost});
				}
			}
			
		}
		
		
		return dist[SIZE -1][SIZE -1];
	}
	
}