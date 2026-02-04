import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] total_s = new int[101][101];
		for(int i = 0; i < T; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			
			for(int j = x; j < x+10; j++) {
				for(int k = y; k < y+10; k++) {
					total_s[j][k] = 1;
				}
				
			}

		}
		int answer = 0;
		for(int j = 0; j <= 100; j++) {
			for(int k = 0; k <= 100; k++) {
				answer += total_s[j][k];
			}
		}
		System.out.println(answer);
	}
}
