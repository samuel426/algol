import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String m = br.readLine();

        int start = 1;
        while(start <= 8) {
            System.out.print(m);
            start += 1;
        }

    }
}