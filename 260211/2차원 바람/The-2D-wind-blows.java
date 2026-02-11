import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);
        int q = Integer.parseInt(arr[2]);

        int[][] building = new int[n][m];
        for (int i = 0; i < n; i++) {
            arr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) building[i][j] = Integer.parseInt(arr[j]);
        }

        for (int qi = 0; qi < q; qi++) {
            arr = br.readLine().split(" ");
            int r1 = Integer.parseInt(arr[0]) - 1;
            int c1 = Integer.parseInt(arr[1]) - 1;
            int r2 = Integer.parseInt(arr[2]) - 1;
            int c2 = Integer.parseInt(arr[3]) - 1;

            // 1) 바람(테두리 시계 회전)
            rotateClockwise(building, r1, c1, r2, c2);

            // 2) 평균 갱신(사각형 내부 전체, 동시 갱신)
            applyAverage(building, r1, c1, r2, c2);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(building[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void rotateClockwise(int[][] a, int r1, int c1, int r2, int c2) {
        int prev = a[r1][c1];

        // top row (left -> right)
        for (int j = c1 + 1; j <= c2; j++) {
            int cur = a[r1][j];
            a[r1][j] = prev;
            prev = cur;
        }
        // right col (top -> bottom)
        for (int i = r1 + 1; i <= r2; i++) {
            int cur = a[i][c2];
            a[i][c2] = prev;
            prev = cur;
        }
        // bottom row (right -> left)
        for (int j = c2 - 1; j >= c1; j--) {
            int cur = a[r2][j];
            a[r2][j] = prev;
            prev = cur;
        }
        // left col (bottom -> top)
        for (int i = r2 - 1; i >= r1; i--) {
            int cur = a[i][c1];
            a[i][c1] = prev;
            prev = cur;
        }
    }

    private static void applyAverage(int[][] a, int r1, int c1, int r2, int c2) {
        int[][] next = new int[n][m];

        // 전체 복사(사각형 밖 유지)
        for (int i = 0; i < n; i++) {
            System.arraycopy(a[i], 0, next[i], 0, m);
        }

        // 사각형 내부만 갱신 (평균은 "격자 안" 이웃이면 모두 포함)
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                int sum = a[i][j];
                int cnt = 1;

                for (int d = 0; d < 4; d++) {
                    int ni = i + dr[d];
                    int nj = j + dc[d];
                    if (ni < 0 || ni >= n || nj < 0 || nj >= m) continue; // 격자 안이면 포함
                    sum += a[ni][nj];
                    cnt++;
                }
                next[i][j] = sum / cnt; // 정수 나눗셈
            }
        }

        // 동시 반영
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                a[i][j] = next[i][j];
            }
        }
    }

}
