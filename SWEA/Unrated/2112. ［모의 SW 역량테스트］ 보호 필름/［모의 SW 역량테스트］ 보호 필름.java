import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int D, W, K;
	static int answer;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(K == 1) {
				answer = 0;
			} else {
				answer = Integer.MAX_VALUE;
				dfs(0, 0);
			}
			
			
			System.out.println("#" + test_case + " "  + answer);
		}
		
	}
	
	// row 번째 행을 처리 중, 지금까지 count개 약품 투입
	private static void dfs(int row, int count) {
		// 가지치기
		if(count >= answer) return;
		
		//현재 상태로 검사 통과하면 정답 갱신
		if(check()) {
			answer = count;
			return;
		}
		
		// 마지막 행까지 다 봤으면 종료
		if(row == D) return;
		
		// 원래 행 백업
		int[] backup = new int[W];
		for(int i = 0; i < W; i++) {
			backup[i] = map[row][i];
		}
		
		// 1. 약품 투입 안 함
		dfs(row + 1, count);
		
		// 2. 전부 0으로 변경
		for(int i = 0; i < W; i++) {
			map[row][i] = 0;
		}
		dfs(row + 1, count + 1);
		
		// 3. 전부 1로 변경
		for(int i = 0; i < W; i++) {
			map[row][i] = 1;
		}
		dfs(row + 1, count + 1);
		
		// 복구
		for(int i = 0; i < W; i++) {
			map[row][i] = backup[i];
		}
	}
	
	// 현재 필름이 성능검사를 통과하는지 확인
	static boolean check() {
		for(int col = 0; col < W; col++) {
			int count = 1;
			boolean pass = false;
			
			for(int row = 1; row < D; row++) {
				if(map[row][col] == map[row - 1][col]) {
					count++;
				} else {
					count = 1;
				}
				
				if(count >= K) {
					pass = true;
					break;
				}
			}
			
			// 시작부터 K가 1인 경우는 main에서 처리
			// 일반적으로 아래도 안전하게 유지 가능
			if(count >= K) pass = true;
			if(!pass) return false;
		}
		
		return true;
	}
	
	
	
}
