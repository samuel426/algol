
import java.util.Scanner;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int line = Integer.parseInt(br.readLine());
            
            if(line == 1) {
                int score1 = Integer.parseInt(br.readLine());
                System.out.println("#" + test_case + " " + score1);
                continue; 
            }
            
            int[][] field = new int[line][line];
            for(int i = 0; i < line; i++) {
                String str = br.readLine();
                for(int j = 0; j < str.length(); j++) {
                    field[i][j] = str.charAt(j) - '0';
                }
            }
            int score = 0;
            for(int i = 0; i < line; i++) {
                int start = Math.abs(line / 2 - i);
                int end = line - start;
                for(int j = start; j < end; j++) {
                    score += field[i][j];
                }
            }
            
            System.out.println("#" + test_case + " " + score);
		}
	}
}