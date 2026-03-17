import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int[] dr = {0, 0, -1, 1};
	private static int[] dc = {1, -1, 0, 0};
	private static boolean[][] isvisited;
	private static int answer, N, M, K;
	private static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			isvisited = new boolean[N][M];
			answer = 0;
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(!isvisited[i][j] && map[i][j] == 1) {
						bfsLabel(i, j);
						answer++;
					}
				}
			}
			
			System.out.println(answer);
			
		}
		
	}
	private static void bfsLabel(int sr, int sc) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sr, sc});
		isvisited[sr][sc] = true;
		map[sr][sc] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0], cc = cur[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = dr[d] + cr;
				int nc = dc[d] + cc;
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(isvisited[nr][nc]) continue;
				if(map[nr][nc] != 1) continue;
				
				isvisited[nr][nc] = true;
				map[nr][nc] = 0;
				q.offer(new int[] {nr, nc});
			}
		}
	}
}
