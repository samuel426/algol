import java.util.Scanner;
public class Main {

    public static int k, n, arr[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        
        arr = new int[n];
        dfs(0, 0, 0);
        System.out.println(sb.toString());

    }
    //pos : 위치, prev : 이전값, run : 연속 횟수
    static void dfs(int pos, int prev, int run) {
        if(pos == n) {
            for(int i = 0; i < n; i++) {
                if(i > 0) sb.append(" ");
                sb.append(arr[i]);
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i <= k; i++) {
            if(pos == 0) {
                arr[pos] = i;
                dfs(pos + 1, i, 1);
            } else {
                if(i == prev) {
                    if(run == 2) continue;
                    arr[pos] = i;
                    dfs(pos + 1, i, run +1);
                } else {
                    arr[pos] = i;
                    dfs(pos + 1, i, 1);
                }
            }
        }
    }
}