import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			
			int[] input = new int[N];
			String[] input_s = br.readLine().split(" ");
			for(int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(input_s[i]);
			}
			Arrays.sort(input);
			int start, end, sum;
			start=end=sum=0;
			end = N-1;
			int max = 0;
			while(start < end) {
				sum = input[start] + input[end];
				if(sum <= M) {
					start++;
					max = Math.max(max, sum);
				}else if(sum > M) {
					end--;
				}
			}
			
			answer = max;
			if(max == 0) answer = -1;
			System.out.println("#" + test_case + " " + answer);
		}
		
	}
}
