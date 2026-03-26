import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dr = {0, 0, 0, 0, 1, -1};
		int[] dc = {0, 0, 1, -1, 0, 0};
		int[] dh = {1, -1, 0, 0, 0, 0};
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][][] box = new int[H][N][M];
		ArrayDeque<int[]> queue = new ArrayDeque<>();

		// 입력
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					box[h][r][c] = Integer.parseInt(st.nextToken());

					// 처음부터 익어있는 토마토는 모두 큐에 넣음
					if (box[h][r][c] == 1) {
						queue.add(new int[] {h, r, c});
					}
				}
			}
		}
		

		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int h = cur[0];
			int r = cur[1];
			int c = cur[2];
			
			for(int d = 0; d < 6; d++) {
				int nh = h + dh[d];
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				}
				
				if(box[nh][nr][nc] == 0) {
					box[nh][nr][nc] = box[h][r][c] + 1;
					queue.add(new int[] {nh, nr, nc});
				}
			}
		}
		
		int answer = 0;
		
		for(int h = 0; h < H; h++) {
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(box[h][r][c] == 0) {
						System.out.println(-1);
						return;
					}
					answer = Math.max(answer, box[h][r][c]);
				}
			}
		}
		System.out.println(answer -1);
	}
}
