import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(sum(n));
    }

    public static int sum(int num) {
        if(num == 0) return 0;
        return sum(num/10) + (num % 10)*(num % 10);
    }
}