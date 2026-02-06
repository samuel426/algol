import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.

        int max = 0;

        int[][] dir = {{-1, 0}, {-1, -1}, {-1, 1}, {0, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}, {1, -1}};
        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < n -1; j++) {
                int temp_sum = 0;
                for(int k = 0; k < 9; k++) {
                    int dx = dir[k][0] + j;
                    int dy = dir[k][1] + i;
                    temp_sum += grid[dy][dx];
                }
                max = Math.max(max, temp_sum);
            }
        }

        System.out.println(max);

    }
}