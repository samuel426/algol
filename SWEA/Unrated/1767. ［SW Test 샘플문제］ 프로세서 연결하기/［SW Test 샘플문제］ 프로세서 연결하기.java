import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	private static int size, map[][], min, maxCore;
	private static ArrayList<int[]> cores;
	
	private static int[] dr = {0, 0, -1, 1};
	private static int[] dc = {-1, 1, 0, 0};
	
	
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			min = Integer.MAX_VALUE;
			maxCore = 0;
			size = Integer.parseInt(br.readLine());
			map = new int[size][size];
			cores = new ArrayList<>();
			for(int i = 0; i < size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1 && i > 0 && i < size-1 && j > 0 && j < size-1) {
						cores.add(new int[] {i, j});
					}
				}
			}
			
			dfs(0, 0, 0);
			System.out.println("#" +  test_case + " " + min);
			
		}
	}
	
	// dept: 현재 탐색 중인 코어 인덱스
	// coreCnt: 연결된 코어 개수
	// lineCnt: 사용된 전선 개수
	public static void dfs(int dept, int coreCnt, int lineCnt) {
		if(dept == cores.size()) {
			if(coreCnt > maxCore) {
				maxCore = coreCnt;
				min = lineCnt;
			} else if(coreCnt == maxCore) {
				min = Math.min(min, lineCnt);		
			}
			return;
		}

		int row = cores.get(dept)[0];
		int col = cores.get(dept)[1];
		
		for(int dir = 0; dir < 4; dir++) {
			int cnt = connect(row, col, dir, 2);
			if(cnt > 0) {
				dfs(dept + 1, coreCnt + 1, lineCnt + cnt);
				connect(row, col, dir, 0);
			}
		}
		
		//연결 안 하는 경우
		dfs(dept + 1, coreCnt, lineCnt);
	}

	private static int connect(int row, int col, int dir, int value) {
	    int r = row + dr[dir];
	    int c = col + dc[dir];
	    int cnt = 0;
	    
	    // value가 2일 때 (연결): 장애물 체크 필요
	    if(value == 2) {
	        // 먼저 끝까지 갈 수 있는지 확인
	        while(r >= 0 && r < size && c >= 0 && c < size) {
	            if(map[r][c] != 0) { // 장애물 발견
	                return 0; // 연결 불가
	            }
	            r += dr[dir];
	            c += dc[dir];
	        }
	        
	        // 갈 수 있으면 실제로 연결
	        r = row + dr[dir];
	        c = col + dc[dir];
	        while(r >= 0 && r < size && c >= 0 && c < size) {
	            map[r][c] = 2;
	            cnt++;
	            r += dr[dir];
	            c += dc[dir];
	        }
	    } 
	    // value가 0일 때 (제거): 그냥 제거만
	    else {
	        while(r >= 0 && r < size && c >= 0 && c < size) {
	            if(map[r][c] == 2) {
	                map[r][c] = 0;
	                cnt++;
	            }
	            r += dr[dir];
	            c += dc[dir];
	        }
	    }
	    
	    return cnt;
	}
}
