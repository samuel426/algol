import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        star(n);
    }

    public static void star(int n) {
        if(n == 0) {
            return;
        }
        star(n-1);

        String s = "";
        for(int i = 0; i < n; i++) {
            s += "*";
        }
        System.out.println(s);
    }
}