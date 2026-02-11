import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static int size, maxH, answer, em[];
	private static boolean[] isSelected;
	
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] arr = br.readLine().split(" ");
			size = Integer.parseInt(arr[0]);
			maxH = Integer.parseInt(arr[1]);
			arr = br.readLine().split(" ");
			em = new int[size];
			for(int i = 0; i < size; i++) {
				em[i] = Integer.parseInt(arr[i]);
			}
			
			answer = Integer.MAX_VALUE;
			isSelected = new boolean[size];
			makeSubSetSum(0,  0, maxH);

			
			System.out.println("#" + test_case + " " + answer);
			
		}
		
	}
	
	public static void makeSubSetSum(int cnt, int pickCnt, int targetSum) {
		if(cnt == size) {
			int sum = 0;
			for(int i = 0; i < size; i++) {
				if(isSelected[i]) {
					sum += em[i];
				}
			}
			if(pickCnt > 0 && targetSum <= sum) {
				answer = Math.min(answer, Math.abs(sum - maxH));
			}
			return;
		}
		
		isSelected[cnt] = true;
		makeSubSetSum(cnt+1, pickCnt+1, targetSum);
		isSelected[cnt] = false;
		makeSubSetSum(cnt+1, pickCnt, targetSum);
	}
}
