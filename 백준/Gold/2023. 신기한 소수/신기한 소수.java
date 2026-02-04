import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int start = 1;
		int end = 1;
		int[] a1 = {2, 3, 5, 7};
		int[] a2 = {1, 3, 7, 9};

		
		if(N == 1) {
			for(int i = 0; i < 4; i++) {
				System.out.println(a1[i]);
			}
			return;
		}
		
		
		for(int i = 0; i < 4; i++) {
			dfs(a1[i], 1, N);
		}
		
	}

	public static void dfs(int a, int s, int target) {
		if(s == target) {
			System.out.println(a);
			return;
		}
		int[] a2 = {1, 3, 7, 9};

		for(int i = 0; i < 4; i++) {
			int num_n = a * 10 + a2[i];
			if(isPrime(num_n)) dfs(num_n, s+1, target);
		}
		
	}

	private static boolean isPrime(int num_n) {
		
		for(int i = 2; i <= Math.sqrt(num_n); i++) {
			if(num_n % i == 0) {
				return false;
			}
		}
		
		
		return true;
	}
}
