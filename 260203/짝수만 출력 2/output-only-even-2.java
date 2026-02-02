import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int b = Integer.parseInt(arr[0]);
        int a = Integer.parseInt(arr[1]);

        while(b >= a) {
            
            if(b % 2 == 0) {
                System.out.print(b + " ");
            }
            b--;
        }

    }
}