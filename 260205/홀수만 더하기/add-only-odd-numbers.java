import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input % 3 == 0 && input % 2 != 0) sum+= input;
        }

        System.out.print(sum);
    }
}