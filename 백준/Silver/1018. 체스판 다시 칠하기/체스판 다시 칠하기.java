import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" ");
		
		int y = Integer.parseInt(arr[0]);
		int x = Integer.parseInt(arr[1]);
		
		String[] input = new String[y];
		for(int i = 0; i < y; i++) {
			input[i] = br.readLine();
		}

		int min = Integer.MAX_VALUE;
		for(int i = 0; i <= y - 8; i++) {
			for(int j = 0; j <= x - 8; j++) {
				int changeW = 0;
				int changeB = 0;
				
				for(int k = 0; k < 8; k++) {
					for(int l = 0; l < 8; l++) {
                        char current = input[i + k].charAt(j + l);
                        
                        char expectedW = ((k + l) % 2 == 0) ? 'W' : 'B';

                        char expectedB = ((k + l) % 2 == 0) ? 'B' : 'W';
                        
                        if (current != expectedW) {
                            changeW++;
                        }
                        if (current != expectedB) {
                            changeB++;
                        }
					}
				}
				min = Math.min(min, Math.min(changeW, changeB));
			}
		}
		
		System.out.println(min);
		br.close();
		
	}
}
