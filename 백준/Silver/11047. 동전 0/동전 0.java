import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int K = Integer.parseInt(line[1]);
		
		int[] coins = new int[N];
		
		for(int i = 0; i < N; i++) {
			int c = Integer.parseInt(br.readLine());
			coins[i] = c;
		}
		int answer = 0;
		for(int i = N - 1; i >= 0; i--) {
			if(coins[i] <= K) {
				answer += K / coins[i];
				K = K % coins[i];
			}
		}
		System.out.println(answer);
	}
}
