import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int sc = Integer.parseInt(br.readLine());
			
			int[] line1 = new int[sc];
			int[] line2 = new int[sc];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < sc; i++) {
				line1[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < sc; i++) {
				line2[i] = Integer.parseInt(st.nextToken());
			}
			
			if(sc == 1) {
				sb.append(Math.max(line1[0], line2[0])).append("\n");
				continue;
			}
			
			int[][] dp = new int[2][sc];

			dp[0][0] = line1[0];
			dp[1][0] = line2[0];
			
			dp[0][1] = dp[1][0] + line1[1];
			dp[1][1] = dp[0][0] + line2[1];
			
			for(int i = 2; i < sc; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + line1[i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + line2[i];
			}
			
			int answer = Math.max(dp[0][sc - 1], dp[1][sc - 1]);
			sb.append(answer).append("\n");
			
		}
		System.out.println(sb);
		
	}
}
