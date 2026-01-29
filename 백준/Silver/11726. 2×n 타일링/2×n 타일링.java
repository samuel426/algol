
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		int a = 1;
		int b = 2;
		
		if(input == 1) {
			System.out.println(a);
			return;
		}
		if(input == 2) {
			System.out.println(b);
			return;
		}
		int answer = 0;
		for(int i = 3; i <= input; i++) {
			answer = (a + b) % 10007;
			a = b;
			b = answer;
		}
		System.out.println(answer);
		
	}

}
