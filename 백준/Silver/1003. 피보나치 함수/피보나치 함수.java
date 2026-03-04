import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int max = 0;
		int[] nums = new int[T];
		for(int i = 0; i < T; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			if(nums[i] > max) max = nums[i];
		}
		
		int[][] dp = new int[Math.max(2, max + 1)][2];
		dp[0][0] = 1; dp[0][1] = 0;
		dp[1][0] = 0; dp[1][1] = 1;
		
		for(int i = 2; i <= max; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i-2][0];
			dp[i][1] = dp[i - 1][1] + dp[i-2][1];
		}
		for(int n : nums) {
			System.out.println(dp[n][0] + " " + dp[n][1]);
		}
	}
}