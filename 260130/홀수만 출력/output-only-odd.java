import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");

        int a = Integer.parseInt(in[0]);
        int b = Integer.parseInt(in[1]);

        for(int i = a; i <= b; i += 2) {
            System.out.print(i + " ");
        }
    }
}