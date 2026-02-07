import java.io.*;
import java.util.*;

public class Main {

    static class Marble {
        int r, c, d;
        Marble(int r, int c, int d) { this.r=r; this.c=c; this.d=d; }
    }

    static int dirToInt(String s) {
        switch (s) {
            case "L": return 0;
            case "R": return 1;
            case "U": return 2;
            default:  return 3; // D
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<Marble> alive = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                int d = dirToInt(st.nextToken());
                alive.add(new Marble(r, c, d));
            }

            // 이동 벡터
            int[] dr = {0, 0, -1, 1};
            int[] dc = {-1, 1, 0, 0};

            // 초기 충돌 제거
            alive = removeCollisions(N, alive);

            int steps = 2 * N; // 핵심: 2N만 돌리기
            for (int t = 0; t < steps && !alive.isEmpty(); t++) {

                // 1) 동시에 이동 (B안: 벽이면 방향만 반전, 이동X)
                for (Marble m : alive) {
                    boolean bounced = false;

                    if (m.d == 0 && m.c == 0) { m.d = 1; bounced = true; }
                    else if (m.d == 1 && m.c == N - 1) { m.d = 0; bounced = true; }
                    else if (m.d == 2 && m.r == 0) { m.d = 3; bounced = true; }
                    else if (m.d == 3 && m.r == N - 1) { m.d = 2; bounced = true; }

                    if (!bounced) {
                        m.r += dr[m.d];
                        m.c += dc[m.d];
                    }
                }

                // 2) 충돌 제거
                alive = removeCollisions(N, alive);
            }

            System.out.println(alive.size());
        }
    }

    static ArrayList<Marble> removeCollisions(int N, ArrayList<Marble> list) {
        int[][] cnt = new int[N][N];

        for (Marble m : list) cnt[m.r][m.c]++;

        ArrayList<Marble> next = new ArrayList<>();
        for (Marble m : list) {
            if (cnt[m.r][m.c] == 1) next.add(m); // 혼자 있는 애만 생존
        }
        return next;
    }
}
