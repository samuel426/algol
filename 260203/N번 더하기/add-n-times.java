import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int a = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);
        a += n;
        for(int i = 0; i < n; i++) {
            System.out.println(a);
            a += n;

        }

    }
}