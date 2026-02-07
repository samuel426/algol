import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }

        int run = t % (2 * n);

        for(int i = 0; i < run; i++) {
            int temp = top[n-1];
            int temp2 = bottom[n-1];
            for(int j = n - 1; j >= 1; j--) {
                top[j] = top[j - 1]; 
                bottom[j] = bottom[j - 1]; 
            }
            top[0] = temp2;
            bottom[0] = temp;
        }

        // Please write your code here.

        for(int i = 0; i < n; i++) {
            System.out.print(top[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++) {
            System.out.print(bottom[i] + " ");
        }

    }
}