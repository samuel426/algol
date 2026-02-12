import java.util.*;
public class Main {
    private static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }


        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        ArrayList<Integer> list = new ArrayList<>();
            
        int min = Integer.MAX_VALUE;
        int ar = -1;
        int ac = -1;

        while(true) {
            ar=ac=-1;
            min = Integer.MAX_VALUE;
            list.add(grid[r][c]);
            
            for(int d = 0; d < 4; d++) {
                int nr = dr[d] + r;
                int nc = dc[d] + c;

                if(!isIn(nr, nc)) continue;
                int temp = grid[r][c] - grid[nr][nc];
                if(temp < 0) {
                    min = Math.min(temp, min);
                    ar = nr;
                    ac = nc;
                    break;
                }
            }
            if(ar == -1) break;
            r = ar;
            c = ac;
        }
        
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static boolean isIn(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}