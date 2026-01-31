import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());

		System.out.println(recur(input, 0));
		
	}
	static int recur(int N, int count) {
		if(N < 2) {
			return count;
		}
		
		return Math.min(recur(N/2, count + 1 + (N % 2)), recur(N/3, count + 1 + (N% 3)));
	}
}
