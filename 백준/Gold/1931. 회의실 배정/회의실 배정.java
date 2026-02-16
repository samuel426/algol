import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[][] meetings = new int[T][2];
		StringTokenizer st;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meetings, (a, b) -> {
			if(a[1] == b[1]) return a[0] - b[0];
			return a[1] - b[1];
		});
		
		int count = 0;
		int lastEnd = 0;
		
		for(int i = 0; i < T; i++) {
			if(meetings[i][0] >= lastEnd) {
				count++;
				lastEnd = meetings[i][1];
			}
		}
		System.out.println(count);
	}
}
