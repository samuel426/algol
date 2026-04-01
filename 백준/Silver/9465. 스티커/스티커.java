import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());

			int[] top = new int[n];
			int[] bottom = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				top[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				bottom[i] = Integer.parseInt(st.nextToken());
			}

			if (n == 1) {
				sb.append(Math.max(top[0], bottom[0])).append('\n');
				continue;
			}

			int topPrev2 = top[0];
			int bottomPrev2 = bottom[0];

			int topPrev1 = bottom[0] + top[1];
			int bottomPrev1 = top[0] + bottom[1];

			for (int i = 2; i < n; i++) {
				int topCur = Math.max(bottomPrev1, bottomPrev2) + top[i];
				int bottomCur = Math.max(topPrev1, topPrev2) + bottom[i];

				topPrev2 = topPrev1;
				bottomPrev2 = bottomPrev1;
				topPrev1 = topCur;
				bottomPrev1 = bottomCur;
			}

			sb.append(Math.max(topPrev1, bottomPrev1)).append('\n');
		}

		System.out.print(sb);
	}
}