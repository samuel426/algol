import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[][] worms;
	static long totalX, totalY;
	static long answer;
	
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= T; test_case++) {
        	answer = Long.MAX_VALUE;
        	
        	N = Integer.parseInt(br.readLine());
        	worms = new int[N][2];
        	totalX = 0;
        	totalY = 0;
        	
        	for(int i = 0; i < N; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		worms[i][0] = Integer.parseInt(st.nextToken());
        		worms[i][1] = Integer.parseInt(st.nextToken());
        		
        		totalX += worms[i][0];
        		totalY += worms[i][1];
        	}
        	
        	dfs(0, 0, 0, 0);
        	
        	System.out.println("#" + test_case + " " + answer);
        }
        
	}
	
	static void dfs(int idx, int count, long selectedX, long selectedY) {
		// N/2마리 선택 완료
		if(count == N / 2) {
			long vx = 2 * selectedX - totalX;
			long vy = 2 * selectedY - totalY;
			
			long value = vx * vx + vy * vy;
			answer = Math.min(answer, value);
			return;
		}
		
		// 끝까지 갔는데 N/2 못 채운 경우
		if(idx == N) {
			return;
		}
		
		// 가지치기: 남은 개수로 N/2 못 채우면 종료
		if(count + (N - idx) < N / 2) {
			return;
		}
		
		// 현재 지렁이 선택
		dfs(idx + 1, count + 1, selectedX + worms[idx][0], selectedY + worms[idx][1]);
		
		// 현재 지렁이 선택 안함
		dfs(idx + 1, count, selectedX, selectedY);
	}
}
