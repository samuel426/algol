import java.util.*;
import java.io.*;

public class Main {

    public static int n, m, answer;
    public static int[][] map;
    public static int[][] visited;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        map = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0);

        System.out.println(answer);
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) {
            return false;
        }
        if(visited[x][y] == 1 || map[x][y] == 0) {
            return false;
        }
        return true;
    }

    public static void DFS(int x, int y) {

        if((x == n - 1) && (y == m - 1)) {
            answer = 1;
        }

        int[] dx = new int[]{1, 0};
        int[] dy = new int[]{0, 1};
        
        visited[x][y] = 1;

        for(int i = 0; i < 2; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(canGo(cx, cy)) {
                DFS(cx, cy);
            }
        }
    }
}