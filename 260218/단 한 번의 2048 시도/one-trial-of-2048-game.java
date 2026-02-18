import java.io.*;
import java.util.*;

public class Main {
    static final int N = 4;
    static int[][] board = new int[N][N];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        char dir = br.readLine().trim().charAt(0);

        move(dir);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
                if (j < N - 1) sb.append(' ');
            }
            if (i < N - 1) sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    static void move(char dir) {
        if (dir == 'L') {
            for (int r = 0; r < N; r++) {
                int[] line = new int[N];
                for (int c = 0; c < N; c++) line[c] = board[r][c];
                int[] merged = mergeLine(line);
                for (int c = 0; c < N; c++) board[r][c] = merged[c];
            }
        } else if (dir == 'R') {
            for (int r = 0; r < N; r++) {
                int[] line = new int[N];
                for (int c = 0; c < N; c++) line[c] = board[r][N - 1 - c]; // 뒤집어서 읽기
                int[] merged = mergeLine(line);
                for (int c = 0; c < N; c++) board[r][N - 1 - c] = merged[c]; // 다시 뒤집어 넣기
            }
        } else if (dir == 'U') {
            for (int c = 0; c < N; c++) {
                int[] line = new int[N];
                for (int r = 0; r < N; r++) line[r] = board[r][c];
                int[] merged = mergeLine(line);
                for (int r = 0; r < N; r++) board[r][c] = merged[r];
            }
        } else if (dir == 'D') {
            for (int c = 0; c < N; c++) {
                int[] line = new int[N];
                for (int r = 0; r < N; r++) line[r] = board[N - 1 - r][c]; // 아래→위로 읽기
                int[] merged = mergeLine(line);
                for (int r = 0; r < N; r++) board[N - 1 - r][c] = merged[r]; // 다시 아래부터 채우기
            }
        }
    }

    // "왼쪽으로" 밀기 기준으로 한 줄(길이 4) 병합
    // 규칙: 0 제거 → 인접한 같은 수 1번만 합치기 → 나머지 0 채우기
    static int[] mergeLine(int[] line) {
        int[] tmp = new int[N];
        int idx = 0;

        // 1) 압축(0 제거)
        for (int i = 0; i < N; i++) {
            if (line[i] != 0) tmp[idx++] = line[i];
        }

        // 2) 병합
        int[] res = new int[N];
        int w = 0;
        for (int i = 0; i < N; i++) {
            if (tmp[i] == 0) break;

            if (i + 1 < N && tmp[i] == tmp[i + 1]) {
                res[w++] = tmp[i] * 2;
                i++; // 다음 타일은 이미 합쳤으니 스킵 (연쇄합치기 방지 핵심)
            } else {
                res[w++] = tmp[i];
            }
        }
        return res; // 뒤는 자동 0
    }
}
