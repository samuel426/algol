import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int M = Integer.parseInt(in[1]);
		
		long[] ms = new long[N];
		
		in = br.readLine().split(" ");
		long max = Long.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			ms[i] = Long.parseLong(in[i]);
			max = Math.max(max, ms[i]);
		}
		
		long left = 0;
		long right = max;
		while(left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			for(long h : ms) {
				if(h > mid) sum += (h - mid);
			}
			if(sum >= M) left = mid + 1;
			else right = mid - 1;
		}
		
		System.out.print(right);
	}
}
