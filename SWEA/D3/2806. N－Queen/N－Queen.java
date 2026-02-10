import java.util.*;
import java.io.*;


class Solution {
    private static int n;
    private static boolean[] colUsed;
    private static boolean[] diag1Used;
    private static  boolean[] diag2Used;
    private static int answer;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++) {
            int input = Integer.parseInt(br.readLine());
            int answer = solution(input);
            System.out.println("#" + i + " " + answer);
        }
        
    }
    
    public static int solution(int num) {
        n = num;
        colUsed = new boolean[n];
        diag1Used = new boolean[2 * n - 1];
        diag2Used = new boolean[2 * n - 1];
        answer = 0;
        backtrack(0);
        return answer;
    }

    private static void backtrack(int row) {
        if(row == n) {
            answer++;
            return;
        }
        for(int col = 0; col < n; col++) {
            int d1 = row - col + (n - 1);
            int d2 = row + col;

            if(colUsed[col] || diag1Used[d1] || diag2Used[d2]) continue;

            colUsed[col] = true;
            diag1Used[d1] = true;
            diag2Used[d2] = true;

            backtrack(row+1);

            colUsed[col] = false;
            diag1Used[d1] = false;
            diag2Used[d2] = false;
        }
    }

    
}