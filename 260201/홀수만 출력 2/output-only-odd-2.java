import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);

        if(a % 2 == 0) a-= 1;
        
        for(int i = a; i >= b; i -= 2) {
            System.out.print(i + " ");
        }

    }
}