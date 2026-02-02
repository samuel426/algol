
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split(" ");
		int total = Integer.parseInt(arr[0]);
		int pw_len = Integer.parseInt(arr[1]);
		
		String original = br.readLine();
		String[] acgt = br.readLine().split(" ");
		int[] min = new int[4];
		min[0] = Integer.parseInt(acgt[0]);
		min[1] = Integer.parseInt(acgt[1]);
		min[2] = Integer.parseInt(acgt[2]);
		min[3] = Integer.parseInt(acgt[3]);
		
		int[][] ACGT = new int[total+1][4];
		
		for(int i = 1; i <= total; i++) {
			
			ACGT[i][0] = ACGT[i-1][0];
			ACGT[i][1] = ACGT[i-1][1];
			ACGT[i][2] = ACGT[i-1][2];
			ACGT[i][3] = ACGT[i-1][3];
			
			
		    char ch = original.charAt(i - 1);
		    
			if(ch == 'A') {
				ACGT[i][0] += 1;
			}else if(ch == 'C') {
				ACGT[i][1] += 1;
			}else if(ch == 'G') {
				ACGT[i][2] += 1;
			}else if(ch == 'T') {
				ACGT[i][3] += 1;
			}
			
		}
		int answer = 0;
		for(int i = 0; i+ pw_len <= total; i++) {
			int l = i;
			int r = i + pw_len;
			
			int a = ACGT[r][0] - ACGT[l][0];
			int c = ACGT[r][1] - ACGT[l][1];
			int g = ACGT[r][2] - ACGT[l][2];
			int tcnt = ACGT[r][3] - ACGT[l][3];
			
			if(a >= min[0] && c >= min[1] && g >= min[2] && tcnt >= min[3]) {
				answer++;
			}
			
		}
		System.out.println(answer);
		
	}	
}
