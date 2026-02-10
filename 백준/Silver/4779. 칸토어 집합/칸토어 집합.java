import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static char[] lines;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while(true) {
			StringBuilder sb = new StringBuilder();
			line = br.readLine();
			if(line == null) break;
			line = line.trim();
			if(line.isEmpty()) continue;
			int n = Integer.parseInt(line);
			n = (int) Math.pow(3, n);
			lines = new char[n];
			for(int i = 0; i < n; i++) {
				lines[i] = '-';
			}
			recur(0, n);
			for(int i = 0; i < n; i++) {
				sb.append(lines[i]);
			}
			System.out.println(sb.toString());
			
		}
		
	}
	
	public static void recur(int start, int length) {
		if(length == 1) return;
		int mid = start + length / 3;
		for(int i = mid; i < mid + length / 3; i++) {
			lines[i] = ' ';
		}
		recur(start, length/3);
		recur(start + 2 * length/3, length/3);
	}

}
