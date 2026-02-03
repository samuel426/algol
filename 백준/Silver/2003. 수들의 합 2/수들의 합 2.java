import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		
		int[] input = new int[N];
		String[] input_s = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(input_s[i]);
		}
		
		int s, e, cnt, sum;
		s=e=cnt=sum=0;
		
		while(true) {
			
			if(sum >= M) {
				if(sum == M) cnt++;
				sum -= input[s++];
			}else if(e == N) {
				break;
			}else {
				sum += input[e++];
			}
			
		}
		System.out.println(cnt);
		
	}

}
