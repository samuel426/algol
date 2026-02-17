import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] selected;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        selected = new boolean[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0);
        System.out.println(answer);
    }

    static void comb(int idx, int cnt) {
        // N/2명 뽑았으면 계산
        if(cnt == N/2) {
            calculate();
            return;
        }

        for(int i = idx; i < N; i++) {
            selected[i] = true;
            comb(i + 1, cnt + 1);
            selected[i] = false;
        }
    }

    static void calculate() {
        int start = 0;
        int link = 0;

        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(selected[i] && selected[j]) {
                    start += S[i][j] + S[j][i];
                }
                else if(!selected[i] && !selected[j]) {
                    link += S[i][j] + S[j][i];
                }
            }
        }

        answer = Math.min(answer, Math.abs(start - link));
    }
}
