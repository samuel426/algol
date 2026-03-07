import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		
		int N = Integer.parseInt(line[0]);
		int K = Integer.parseInt(line[1]);
		
		int[] weight = new int[N];
		int[] value = new int[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
			
		}
		
		
		int[] dp = new int[K + 1];

		for(int i = 0; i < N; i++) {
		    int w = weight[i];
		    int v = value[i];

		    for(int j = K; j >= w; j--) {
		        dp[j] = Math.max(dp[j], dp[j - w] + v);
		    }
		}
		
		System.out.println(dp[K]);
		
		
	}
}
