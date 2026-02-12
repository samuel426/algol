import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] map;
	private static int N, price;
	
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] arr = br.readLine().split(" ");
			N = Integer.parseInt(arr[0]);
			price = Integer.parseInt(arr[1]);
			
			map = new int[N][N];
			List<int[]> houses = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						houses.add(new int[] {i, j});
					}
				}
			}
			int answer = 0;
			
			for(int sr = 0; sr < N; sr++) {
				for(int sc = 0; sc < N; sc++) {
					for(int k = 1; k <= 2*N; k++) {
						int cost = k * k + (k - 1) * (k - 1);
						if(houses.size() * price < cost) continue;
						int cnt = 0;
						for(int i = 0; i < houses.size(); i++) {
							int[] cur = houses.get(i);
							if(Math.abs(cur[0] - sr) + Math.abs(cur[1] - sc) < k) cnt++;
						}
						if(cnt*price >= cost) answer = Math.max(answer, cnt);
					}
				}
			}
			
//			int n = 5; // 배열 크기 (홀수)
//			int[][] map = new int[n][n]; // 데이터가 담긴 2차원 배열
//			int center = n / 2;
//			int sum = 0;
//			int k = 2; // 마름모 반경 (중심 포함 거리)
//
//			for (int i = 0; i < n; i++) {
//			    for (int j = 0; j < n; j++) {
//			        // 맨해튼 거리 공식: |행 차이| + |열 차이| <= 거리
//			        if (Math.abs(i - center) + Math.abs(j - center) <= k) {
//			            sum += map[i][j]; // 마름모 범위 내 요소 탐색
//			        }
//			    }
//			}

			
			System.out.println("#" + test_case + " " +answer);
		}
	}
}
