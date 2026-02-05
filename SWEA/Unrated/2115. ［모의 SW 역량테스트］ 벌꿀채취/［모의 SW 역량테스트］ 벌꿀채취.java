import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int M = 0;
	private static int[][] square;
	private static int maxValue, C; 

	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			square = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					square[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			
			int[][] maxProfit = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <= N - M; j++) {
					maxProfit[i][j] = getMaxProfit(i, j);
				}
			}
			
			int answer = 0;
			for(int r1 = 0; r1 < N; r1++) {
				for(int c1 = 0; c1 <= N - M; c1++) {
					
					for(int r2 = 0; r2 < N; r2++) {
						for(int c2 = 0; c2 <= N - M; c2++) {
							if(isNotOverLap(r1, c1, r2, c2)) {
								answer = Math.max(answer, maxProfit[r1][c1] + maxProfit[r2][c2]);
							}
						}
						
					}
				
				}
				
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}

	private static boolean isNotOverLap(int r1, int c1, int r2, int c2) {

		if(r1 != r2) return true;
		
		return c1 + M <= c2 || c2 + M <= c1;
	}

	private static int getMaxProfit(int row, int startCol) {
		int[] honey = new int[M];
		for(int i = 0; i < M; i++) {
			honey[i] = square[row][startCol + i];
		}
		maxValue = 0;
		dfs(honey, 0, 0, 0);
		
		return maxValue;
	}

	private static void dfs(int[] honey, int idx, int sum, int profit) {

		if(sum > C) return;
		
		if(idx == M) {
			maxValue = Math.max(maxValue, profit);
			return;
		}
		// 선택
		dfs(honey, idx + 1, sum + honey[idx], profit + honey[idx] * honey[idx]);
		// 미선택
		dfs(honey, idx + 1, sum, profit);
		
	}
	
	
}
