import java.io.*;
import java.util.*;

public class Main {

    static class Marble {
        int r, c;   // 0-based
        int d;      // 0:L, 1:R, 2:U, 3:D
        boolean alive = true;

        Marble(int r, int c, int d) {
            this.r = r; this.c = c; this.d = d;
        }
    }

    static int dirToInt(String s) {
        switch (s) {
            case "L": return 0;
            case "R": return 1;
            case "U": return 2;
            default:  return 3; // "D"
        }
    }

    static String encodeState(List<Marble> marbles) {
        // 살아있는 구슬만 (r,c,d) 뽑아서 정렬 후 문자열로
        List<int[]> list = new ArrayList<>();
        for (Marble m : marbles) {
            if (m.alive) list.add(new int[]{m.r, m.c, m.d});
        }
        list.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        StringBuilder sb = new StringBuilder();
        for (int[] x : list) {
            sb.append(x[0]).append(',').append(x[1]).append(',').append(x[2]).append(';');
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Marble> marbles = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken()) - 1; // 0-based
                int c = Integer.parseInt(st.nextToken()) - 1;
                int d = dirToInt(st.nextToken());
                marbles.add(new Marble(r, c, d));
            }

            // 초기부터 겹치면 즉시 제거 처리
            killCollisions(N, marbles);

            HashSet<String> seen = new HashSet<>();

            while (true) {
                // 현재 상태가 반복이면 종료
                String key = encodeState(marbles);
                if (!seen.add(key)) break;

                int[] dr = {0, 0, -1, 1};
                int[] dc = {-1, 1, 0, 0};

                int[][] nextRCd = new int[marbles.size()][3];

                for (int i = 0; i < marbles.size(); i++) {
                    Marble m = marbles.get(i);
                    if (!m.alive) continue;

                    int r = m.r, c = m.c, d = m.d;

                    boolean bounced = false; // 이번 턴에 벽에 닿아서 "이동 안 함" 여부

                    if (d == 0 && c == 0) { d = 1; bounced = true; }          // L at left wall -> R
                    else if (d == 1 && c == N - 1) { d = 0; bounced = true; } // R at right wall -> L
                    else if (d == 2 && r == 0) { d = 3; bounced = true; }     // U at top -> D
                    else if (d == 3 && r == N - 1) { d = 2; bounced = true; } // D at bottom -> U

                    // B안: 벽에서 반전한 턴에는 이동하지 않음
                    if (!bounced) {
                        r += dr[d];
                        c += dc[d];
                    }

                    nextRCd[i][0] = r;
                    nextRCd[i][1] = c;
                    nextRCd[i][2] = d;
                }

                // 적용
                for (int i = 0; i < marbles.size(); i++) {
                    Marble m = marbles.get(i);
                    if (!m.alive) continue;
                    m.r = nextRCd[i][0];
                    m.c = nextRCd[i][1];
                    m.d = nextRCd[i][2];
                }

                // 충돌 제거
                killCollisions(N, marbles);

                // 모두 죽었으면 바로 종료
                if (countAlive(marbles) == 0) break;
            }

            System.out.println(countAlive(marbles));
        }
    }

    static int countAlive(List<Marble> marbles) {
        int cnt = 0;
        for (Marble m : marbles) if (m.alive) cnt++;
        return cnt;
    }

    static void killCollisions(int N, List<Marble> marbles) {
        // 칸에 몇 개 있는지 세고, 2개 이상인 칸의 구슬 모두 제거
        // key = r*N + c
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (Marble m : marbles) {
            if (!m.alive) continue;
            int key = m.r * N + m.c;
            cnt.put(key, cnt.getOrDefault(key, 0) + 1);
        }
        for (Marble m : marbles) {
            if (!m.alive) continue;
            int key = m.r * N + m.c;
            if (cnt.get(key) >= 2) m.alive = false;
        }
    }
}
