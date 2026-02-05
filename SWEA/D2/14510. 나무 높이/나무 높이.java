import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int tree_cnt = Integer.parseInt(br.readLine());
			int[] trees = new int[tree_cnt];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < tree_cnt; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(trees);
			int max = trees[tree_cnt - 1];
			
			int odd = 0;
			int even = 0;
			
			for(int i = 0; i < tree_cnt; i++) {
				int diff = max - trees[i];
				even += diff / 2;
				odd += diff % 2;
			}
			
			// even을 odd로 변환하여 균형 맞추기
			while(even > odd + 1) {
				even--;
				odd += 2;
			}
			
			// 최종 일수 계산
			int answer = Math.max(odd * 2 - 1, even * 2);
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}