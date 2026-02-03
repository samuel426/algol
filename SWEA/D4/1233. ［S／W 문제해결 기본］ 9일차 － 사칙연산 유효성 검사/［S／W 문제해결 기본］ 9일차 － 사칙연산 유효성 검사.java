import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
	
public class Solution {


	public static void main(String args[]) throws Exception {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st;
		for(int test_case = 1; test_case <= 10; test_case++) {
			int line = Integer.parseInt(br.readLine());
			boolean flag = true;
			for(int l = 0; l < line; l++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				String cal = st.nextToken();
				
				if(cal.equals("-") || cal.equals("+") || cal.equals("*") || cal.equals("/")) {
					if(st.countTokens() != 2) {
						flag = false;
					}
				} else {
					if(st.countTokens() != 0) {
						flag = false;
					}
				}
				
			}
			if(flag) {
				System.out.println("#" + test_case + " 1");
			} else {
				System.out.println("#" + test_case + " 0");
			}
		}
			
	}
}
