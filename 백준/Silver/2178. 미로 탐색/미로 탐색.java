import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static int SIZE_R, SIZE_C;
	private static char[][] MIR;
	private static int[] dirx = {0, 0, 1, -1};
	private static int[] diry = {1, -1, 0, 0};
	private static boolean[][] visited;
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		SIZE_R = Integer.parseInt(in[0]);
		SIZE_C = Integer.parseInt(in[1]);
		
		visited = new boolean[SIZE_R][SIZE_C];
		MIR = new char[SIZE_R][SIZE_C];
		for(int i = 0; i < SIZE_R; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j < SIZE_C; j++) {
				MIR[i][j] = line[j];
			}
		}
		
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0, 1});

		int min = 0;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			if(current[0] == SIZE_R -1 && current[1] == SIZE_C -1) {
				min = current[2];
			}
			
			for(int i = 0; i < 4; i++) {
				int dr = dirx[i] + current[0];
				int dc = diry[i] + current[1];
				
				if(dr >= 0 && dr < SIZE_R && dc >= 0 && dc < SIZE_C && !visited[dr][dc] && MIR[dr][dc] == '1') {
					queue.offer(new int[] {dr, dc, current[2] + 1});
					visited[dr][dc] = true;
				}
			}
			
		}
		System.out.print(min);
		
	}
}
