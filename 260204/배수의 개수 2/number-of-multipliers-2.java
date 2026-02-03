import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int cnt = 0;
        for(int i = 0; i < 10; i++) {
            int input = Integer.parseInt(br.readLine());
            if((input % 2 == 1)) {
                cnt++;
            }
        }
        System.out.print(cnt);

    }
}