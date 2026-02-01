import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = t; i > 0; i--) {
            System.out.print(i + " ");
        }
    }
}