import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        hello(n);
    }
    public static void hello(int n) {
        if(n == 0) return;
        System.out.println("HelloWorld");
        hello(n-1);
    }
}