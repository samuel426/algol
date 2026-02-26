import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        asc(n, n);
        dec(n);
    }
    public static void asc(int n, int start) {
        if(n == 0) {
            return;
        }
        asc(n-1, start);
        if(n == start) {
            System.out.println(n + " ");
            return;
        } else {
            System.out.print(n + " ");
        }
    }
    public static void dec(int n) {
        if(n == 0) {
            System.out.println();
            return;
        }
        System.out.print(n + " ");
        dec(n-1);
    }
}