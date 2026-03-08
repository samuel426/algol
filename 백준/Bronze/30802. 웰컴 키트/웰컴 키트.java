import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] s = new int[6];
		
		for(int i = 0; i < 6; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		
		String[] line = br.readLine().split(" ");
		int T = Integer.parseInt(line[0]);
		int P = Integer.parseInt(line[1]);

		int ansT = 0;
		int ansP = 0, pen = 0;
		
		for(int i = 0; i < 6; i++) {
			if(s[i] == 0) continue;
			if(s[i] % T == 0) {
				ansT += s[i] / T;
			} else {
				ansT += (s[i] / T) + 1;
			}
		}
		ansP = N / P;
		pen = N % P;
		
		System.out.println(ansT);
		System.out.println(ansP + " " + pen);
		
	}

}
