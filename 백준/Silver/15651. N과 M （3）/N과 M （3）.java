import java.io.*;


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
		permute(0);
		
		System.out.println(sb);
	}

	private static void permute(int depth) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		for(int i = 1; i <= N; i++) {
			numbers[depth] = i;
			permute(depth + 1);
		}
	}
}
