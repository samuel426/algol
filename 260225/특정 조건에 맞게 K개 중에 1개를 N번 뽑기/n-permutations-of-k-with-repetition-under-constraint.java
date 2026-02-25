import java.util.Scanner;

public class Main {

    public static int k, n;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        // Please write your code here.

        arr = new int[n];

        perm(0);

    }

    public static void perm(int depth) {
        if(depth == n) {
            StringBuilder sb = new StringBuilder();
            for(int i : arr) sb.append(i).append(" ");
            System.out.println(sb);
            return;
        }

        for(int i = 1; i <= k; i++) {
            arr[depth] = i;
            perm(depth + 1);
        }
    }
}