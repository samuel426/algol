import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static char[][] map;
	public static int SIZE, answer, answer2;
	public static boolean[][] visited;
	public static int[] dr = {1, -1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		SIZE = Integer.parseInt(br.readLine());
		
		map = new char[SIZE][SIZE];
		
		for(int i = 0; i < SIZE; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j < SIZE; j++) {
				map[i][j] = line[j];
			}
		}
		count();
		System.out.println(answer + " " + answer2);
	}

	private static void count() {
		visited = new boolean[SIZE][SIZE];
		answer = 0;
		
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(!visited[i][j]) {
					bfsCount(i, j);
					answer++;
				}
			}
		}
		
		visited = new boolean[SIZE][SIZE];
		answer2 = 0;
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(!visited[i][j]) {
					bfsRGCount(i, j);
					answer2++;
				}
			}
		}
	}

	private static void bfsCount(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		visited[i][j] = true;
		char c = map[i][j];
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0], cc = cur[1];
			for(int d = 0; d < 4; d++) {
				int nr = dr[d] + cr;
				int nc = dc[d] + cc;
				if(nr < 0 || nr >= SIZE || nc < 0 || nc >= SIZE) continue;
				if(visited[nr][nc]) continue;
				if(c != map[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
		
	}

	private static void bfsRGCount(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		visited[i][j] = true;
		char c = map[i][j];
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0], cc = cur[1];
			for(int d = 0; d < 4; d++) {
				int nr = dr[d] + cr;
				int nc = dc[d] + cc;
				if(nr < 0 || nr >= SIZE || nc < 0 || nc >= SIZE) continue;
				if(visited[nr][nc]) continue;
				if(c == 'R' || c == 'G') {
					if(map[nr][nc] == 'B') continue;
				} else if(c == 'B') {
					if(map[nr][nc] == 'R' || map[nr][nc] == 'G') continue;
				}
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}		
	}
}
