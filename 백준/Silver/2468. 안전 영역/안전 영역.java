import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] input = new int[N][N];
		int maxH = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, input[i][j]);
			}	
		}
		int max = 0;
		for(int i = 0; i <= maxH; i++) {
			max = Math.max(max, drowning(input, i));
		}
		
		System.out.println(max);
	}
	
	public static int drowning(int[][] arr, int d) {
		int count = 0;
		int size = arr.length;
		boolean[][] visit = new boolean[size][size];
		
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(visit[i][j] || arr[i][j] <= d) continue;
				count++;
				dfs(arr, visit, i, j, d, dx, dy);
				
			}
		}
		return count;
	}

	public static void dfs(int[][] arr, boolean[][] visit, int x, int y, int d, int[] dx, int[] dy) {
		visit[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr.length) {
				if(!visit[nx][ny] && arr[nx][ny] > d) {
					dfs(arr, visit, nx, ny, d, dx, dy);
				}
			}
			
		}
		
	}
	
}
