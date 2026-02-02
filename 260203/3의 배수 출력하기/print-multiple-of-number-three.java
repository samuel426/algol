import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int start = 3;
        while(start <= N) {
            System.out.print(start + " ");
            start += 3;
        }

    }
}