import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = {0, 1};
	static int[] dc = {1, 0};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		
		int[][] maze = new int[N][M];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[N][M];
		
		dp[0][0] = maze[0][0];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i == 0 && j == 0) continue;
				
				int max = 0;
				if(i > 0) max = Math.max(max, dp[i - 1][j]);
				if(j > 0) max = Math.max(max, dp[i][j - 1]);
				if(i > 0 && j > 0) max = Math.max(max, dp[i - 1][j - 1]);
				
				dp[i][j] = max + maze[i][j];
				
			}
		}
		System.out.println(dp[N - 1][M - 1]);

	}

}
