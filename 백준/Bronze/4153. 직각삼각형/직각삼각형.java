import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] input_s = br.readLine().split(" ");
			int[] input = new int[3];
			input[0] = Integer.parseInt(input_s[0]);
			input[1] = Integer.parseInt(input_s[1]);
			input[2] = Integer.parseInt(input_s[2]);
			
			Arrays.sort(input);
			
			if((input[0] == 0) & (input[1] == 0) & (input[2] == 0)) {
				break;
			}
			
			int sum = input[0] * input[0] + input[1] * input[1];
			int dif = input[2] * input[2];
			if(sum == dif) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
			
		}
		
		

	}

}
