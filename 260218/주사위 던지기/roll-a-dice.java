import java.util.Scanner;

public class Main {
    private static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        String[] directions = new String[m];
        for (int i = 0; i < m; i++) {
            directions[i] = sc.next();
        }
        // Please write your code here.
        int[][] map = new int[n][n];

        int[] dice = {1, 6, 2, 5, 4, 3};
        map[r][c] = 6;
        for(int i = 0; i < m; i++) {
            String d = directions[i];
            
            int nr = r;
            int nc = c;

            if(d.equals("L")) nc--;
            else if(d.equals("R")) nc++;
            else if(d.equals("U")) nr--;
            else if(d.equals("D")) nr++;

            if(!isIn(nr, nc)) continue;

            // 이동
            r = nr;
            c = nc;

            // 회전
            if(d.equals("L")) {
                int temp = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[1];
                dice[1] = dice[4];
                dice[4] = temp;
                map[r][c] = dice[1];
            }
            else if(d.equals("R")) {
                int temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[1];
                dice[1] = dice[5];
                dice[5] = temp;
                map[r][c] = dice[1];
            }
            else if(d.equals("U")) {
                int temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[1];
                dice[1] = dice[3];
                dice[3] = temp;
                map[r][c] = dice[1];
            }
            else if(d.equals("D")) {
                int temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[1];
                dice[1] = dice[2];
                dice[2] = temp;
                map[r][c] = dice[1];
            }
        }
        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    public static boolean isIn(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}