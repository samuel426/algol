import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	static int n, r;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr_s = br.readLine().split(" ");
		n = Integer.parseInt(arr_s[0]);
		r = Integer.parseInt(arr_s[1]);
		
		arr = new int[n];
		output = new int[r];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		perm(0);
		
	}
	
	private static void perm(int depth) {
		if(depth == r) {
			for(int idx = 0; idx < r; idx++) {
				System.out.print(output[idx] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			output[depth] = arr[i];
			perm(depth + 1);
			visited[i] = false;
		}
	}
}
