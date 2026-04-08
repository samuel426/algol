import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 물건 개수
			int K = Integer.parseInt(st.nextToken()); // 가방 부피
			
			int[][] dp = new int[N + 1][K + 1];
			
			int[] v = new int[N + 1];
			int[] c = new int[N + 1];
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				v[i] = Integer.parseInt(st.nextToken());
				c[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= K; j++) {
					if(j < v[i]) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = Math.max(dp[i-1][j - v[i]] + c[i], dp[i-1][j]);
					}
				}
			}
			
			
			answer = dp[N][K];
			
			System.out.println("#" + test_case + " " + answer);
		}


	}

}
