import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	private static int N, S, answer;
	private static int[] stones;
	private static boolean[] visited;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		
		N = Integer.parseInt(line[0]);
		S = Integer.parseInt(line[1]);
		
		answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		stones = new int[N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0);
		if(S == 0) {
			answer--;
		}
		
		System.out.println(answer);
	}
	
	public static void comb(int depth, int sum) {

		if(depth == N) {
			if(sum == S) {
				answer++;
			}
			return;
		}
		
		
		//안 고를때
		comb(depth + 1, sum);
		//고를때
		comb(depth + 1, sum + stones[depth]);
		


	}
}