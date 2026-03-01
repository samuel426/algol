import java.util.Scanner;
public class Main {
    public static int max = Integer.MIN_VALUE;
    public static int[] arr;
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        find_max(0);
        System.out.print(max);
    }

    public static void find_max(int depth) {
        if(depth == n) {
            return;
        }
        if(max < arr[depth]) {
            max = arr[depth];
        }
        find_max(depth + 1);
    }
}