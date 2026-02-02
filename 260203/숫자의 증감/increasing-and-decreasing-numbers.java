import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        String a = arr[0];
        int n = Integer.parseInt(arr[1]);

        if(a.equals("A")) {
                for(int i = 1; i <= n; i++) {
                        System.out.print(i + " ");
                }
        }else if(a.equals("D")) {
                for(int i = n; i >= 1; i--) {
                        System.out.print(i + " ");
                }
        }
    }
}