import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int N, M;
	private static boolean[][] g;
	
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine()); // 학생수
			M = Integer.parseInt(br.readLine()); // 키 비교 횟수 
			g = new boolean[N+1][N+1];
			for(int i = 0 ; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				g[a][b] = true;
			}
			
			for(int k = 1; k <= N; k++) {
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= N; j++) {
						if(g[i][k] && g[k][j]) g[i][j] = true;
					}
				}
			}
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				int known = 0;
				for(int j = 1; j <= N; j++) {
					if(i == j) continue;
					if(g[i][j] || g[j][i]) known++;
				}
				if(known == N-1) ans++;
			}
			
			System.out.println("#" + test_case + " " + ans);
			
		}
		
	}
}
