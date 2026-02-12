import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int[][] recips;
	private static int answer, N;
	private static boolean[] pick;
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			recips = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					recips[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = Integer.MAX_VALUE;
			pick = new boolean[N];
			pick[0] = true;
			comb(1, 1);
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
	
	public static void comb(int idx, int cnt) {
		if(cnt == N/2) {
			answer = Math.min(answer, clacDiff());
			return;
		}
		if(idx == N) return;
		
		pick[idx] = true;
		comb(idx + 1, cnt + 1);
		
		pick[idx] = false;
		comb(idx + 1, cnt);
	}

	private static int clacDiff() {
		int sumA = 0, sumB = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				int s = recips[i][j] + recips[j][i];
				if(pick[i] && pick[j]) sumA += s;
				else if (!pick[i] && !pick[j]) sumB += s;
			}
		}
		
		return Math.abs(sumA - sumB);
	}
}
