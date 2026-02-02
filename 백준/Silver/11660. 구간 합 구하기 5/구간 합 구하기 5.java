import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split(" ");
		int size = Integer.parseInt(arr[0]);
		int cal = Integer.parseInt(arr[1]);
		
		int[][] input = new int[size][size];
		for(int i = 0; i < size; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0; j < size; j++) {
				input[i][j] = Integer.parseInt(line[j]);
			}
		}
		

		
		int[][] prefix = new int[size+1][size+1];

		for(int i = 1; i <= size; i++) {
			for(int j = 1; j <= size; j++) {
				prefix[i][j] = input[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
			}
		}
		
		for(int i = 0; i < cal; i++) {
			String[] line = br.readLine().split(" ");
			int x1 = Integer.parseInt(line[0]);
			int x2 = Integer.parseInt(line[2]);
			int y1 = Integer.parseInt(line[1]);
			int y2 = Integer.parseInt(line[3]);
			
			int answer = prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1] + prefix[x1 -1][y1 -1];
			System.out.println(answer);
		}
				
	}
}
