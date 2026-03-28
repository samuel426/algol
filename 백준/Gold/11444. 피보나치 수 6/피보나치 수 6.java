import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final long MOD = 1000000007L;

	public static void main(String args[]) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long T = Long.parseLong(br.readLine());
		
		if(T == 0) {
			System.out.println(0);
			return;
		}
		
		long[][] base = {
			{1, 1},
			{1, 0}
		};
		
		long[][] answer = power(base, T);
        // F(n)은 여기서 꺼내기
		System.out.println(answer[0][1]);
	}

	private static long[][] power(long[][] matrix, long n) {

		// 1. 종료 조건
		if(n == 1) {
			return matrix;
		}
		
        // 2. 절반 먼저 구하기
		long[][] half = power(matrix, n / 2);
		
        // 3. half * half
		long[][] temp = multiply(half, half);
		
        // 4. n이 홀수면 matrix 한 번 더 곱하기
		if(n % 2 == 1) {
			temp = multiply(temp, matrix);
		}
		
		return temp;
	}

	private static long[][] multiply(long[][] a, long[][] b) {
		
		long[][] result = new long[2][2];
		
		result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
		result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
		result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
		result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
		
		return result;
	}
}
