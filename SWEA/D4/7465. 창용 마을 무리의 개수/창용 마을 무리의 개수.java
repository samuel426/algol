import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int N, M;
	private static int[] parent;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parent = new int[N + 1];
			
			for(int i = 1; i <= N; i++) { // 여기에 index 값별로 숫자들 넣고
				parent[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				unionParent(from, to); // 합치기
			}
			
			for(int i = 1; i <= N; i++) {
				if(parent[i] == i) {
					answer++;
				}
			}
			
			System.out.println("#"+ test_case + " " + answer);
		}
		
		
		
	}
	
	private static int getParent(int x) {
		// 이게 핵심 
		if(parent[x] == x) return x;
		else return parent[x] = getParent(parent[x]);
	}
	
	private static void unionParent(int x, int y) { //합치는 과정
		x = getParent(x);
		y = getParent(y);
		
		if(x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}
}
