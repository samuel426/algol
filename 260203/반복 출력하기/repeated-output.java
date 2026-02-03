import java.util.Scanner;

public class Main {
    public static void printStrings(int num) {
        for(int i = 0; i < num; i++)
            System.out.println("12345^&*()_");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        printStrings(n);
    }
}