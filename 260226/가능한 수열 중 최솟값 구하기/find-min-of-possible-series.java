import java.util.*;

public class Main {

    static int N;
    static char[] digits = {'4', '5', '6'};
    static StringBuilder sb = new StringBuilder();
    static boolean done = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dfs();
        System.out.println(sb);
    }

    static void dfs() {
        if(done) return;

        int len = sb.length();
        if(len == N) {
            done = true;
            return;
        }

        for(char d : digits) {
            sb.append(d);
            if(isGood()) {
                dfs();
                if (done) return;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static boolean isGood() {
        int len = sb.length();
        for(int k = 1; k <= len / 2; k++) {
            boolean same = true;

            for(int i = 0; i < k; i++) {
                char a = sb.charAt(len - 1 - i);
                char b = sb.charAt(len - 1 - k - i);
                if(a != b) {
                    same = false;
                    break;
                }
            }
            if(same) return false;
        }
        return true;
    }
}