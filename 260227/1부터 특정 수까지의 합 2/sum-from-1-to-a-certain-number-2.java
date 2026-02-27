import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(sum(n));
    }

    public static int sum(int num) {
        if(num == 1) return 1;
        return sum(num-1) + num;
    }
}