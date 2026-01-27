import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		int cnt = 0;
		while(input != 0) {
			if (input >= 3) {
				input -= 3;
			} else if(1 <= input && input < 3) {
				input -= 1;
			}
			cnt++;
		}
		if(cnt % 2 == 0) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}

}