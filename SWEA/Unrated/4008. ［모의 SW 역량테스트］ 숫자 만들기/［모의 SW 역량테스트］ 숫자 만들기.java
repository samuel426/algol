import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int dept = 0;
	private static int min, max, N;
	private static int[] nums;
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			dept = 0;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			N = Integer.parseInt(br.readLine());
			int plus = 0;
			int minus = 0;
			int mul = 0;
			int div = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			plus = Integer.parseInt(st.nextToken());
			minus = Integer.parseInt(st.nextToken());
			mul = Integer.parseInt(st.nextToken());
			div = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			nums = new int[N];
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(1, nums[0], plus, minus, mul, div);
			
			int answer = max - min;
			
			System.out.println("#" + test_case + " " + answer);
		}
	}

	private static void dfs(int dept, int result, int plus, int minus, int mul, int div) {
		
		if(dept == N) {
			min = Math.min(min, result);
			max = Math.max(max, result);
		}
		
		if(plus > 0) {
			dfs(dept + 1, result + nums[dept], plus - 1, minus, mul, div);
		}
		if(minus > 0) {
			dfs(dept + 1, result - nums[dept], plus, minus - 1, mul, div);
		}
		if(mul > 0) {
			dfs(dept + 1, result * nums[dept], plus, minus, mul - 1, div);
		}
		if(div > 0) {
			dfs(dept + 1, result / nums[dept], plus, minus, mul, div - 1);
		}
	}
}
