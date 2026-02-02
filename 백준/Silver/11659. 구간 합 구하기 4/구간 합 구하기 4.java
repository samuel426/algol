import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split(" ");
		int tests = Integer.parseInt(arr[1]);
		String[] input_s = br.readLine().split(" ");
		

		int[] prefix = new int[input_s.length + 1];
		for(int i = 1; i < prefix.length; i++) {
			prefix[i] = prefix[i - 1] + Integer.parseInt(input_s[i-1]);
		}
		
		
		for(int i = 0; i < tests; i++) {
			String[] se = br.readLine().split(" ");
			int start = Integer.parseInt(se[0]);
			int end = Integer.parseInt(se[1]);
			
			int answer = prefix[end] - prefix[start-1];
			
			System.out.println(answer);
		}
		
	}
	
}
