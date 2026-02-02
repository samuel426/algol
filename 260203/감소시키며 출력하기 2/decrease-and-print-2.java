import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int start = 26;
        while(start >= 10) {
            System.out.print(start + " ");
            start -= 1;
        }

    }
}