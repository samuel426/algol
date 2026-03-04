import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		Long i1 = Long.parseLong(input[0]);
		Long i2 = Long.parseLong(input[1]);
		Long r = Long.parseLong(input[2]);
		long result = 1;
		i1 %= r;
		while(i2 > 0) {
			if((i2 & 1) == 1) {
				result = (result * i1) % r;
			}
			i1 = (i1*i1) % r;
			i2 >>= 1;
		}
		
		System.out.println(result);
	}
}