import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
	public static int[] numbers;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		numbers = new int[M];
		combinationWithRep(0, 1);
		
		System.out.println(sb);
	}

	private static void combinationWithRep(int depth, int start) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		for(int i = start; i <= N; i++) {
			numbers[depth] = i;
			combinationWithRep(depth + 1, i);
		}
	}
}
