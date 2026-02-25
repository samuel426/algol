import java.util.*;

public class Main {

    public static int n, segments[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
                if (a <= b) { segments[i][0] = a; segments[i][1] = b; }
            else { segments[i][0] = b; segments[i][1] = a; }
        }
        
        int cnt = 0;
        int lastEnd = Integer.MIN_VALUE;
        
        Arrays.sort(segments, (x, y) -> {
            if (x[1] != y[1]) return x[1] - y[1];
            return x[0] - y[0];
        });

        for (int i = 0; i < n; i++) {
            int s = segments[i][0];
            int e = segments[i][1];

            if (s > lastEnd) {
                cnt++;
                lastEnd = e;
            }
        }

        System.out.println(cnt);
    }

}