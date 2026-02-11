import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int answer = 0;
        for(int i = 0; i < n; i++) {
            int temp = grid[0][i];
            int ans = 1;
            boolean happy = (m == 1);
            for(int j = 1; j < n; j++) {
                if(temp == grid[j][i]) ans++;
                else {
                    temp = grid[j][i];
                    ans = 1;
                }
                if(ans >= m) happy = true;
            }
            if(happy) answer++;
        }
        for(int i = 0; i < n; i++) {
            int temp = grid[i][0];
            int ans = 1;
            boolean happy = (m == 1);
            for(int j = 1; j < n; j++) {
                if(temp == grid[i][j]) ans++;
                else {
                    temp = grid[i][j];
                    ans = 1;
                }
                if(ans >= m) happy = true;
            }
            if(happy) answer++;
        }
        System.out.println(answer);
    }
}