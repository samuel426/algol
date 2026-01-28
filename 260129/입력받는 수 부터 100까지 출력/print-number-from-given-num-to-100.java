import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int in = Integer.parseInt(br.readLine());

        for(int i = in; i <= 100; i++) {
            System.out.print(i + " ");
        }

    }
}