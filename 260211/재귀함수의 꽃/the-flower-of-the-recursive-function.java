import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        flower(n);
    }

    public static void flower(int cnt) {
        if(cnt < 1) return;

        System.out.print(cnt + " ");
        flower(cnt -1);
        System.out.print(cnt + " ");
    }
}