import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        
        int len = a.length;
        boolean sorted = true;
        
        do {
            sorted = true;
            for(int i = 0; i < len-1; i++) {
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    sorted = false;
                }

            }

        } while (sorted == false);

        for(int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
    }
}