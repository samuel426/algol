import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 1; i <= a; i++) {

            if((i % 100 == 0) && (i % 400 != 0)) {
            } else if(i % 4 == 0) {
                cnt++;
            }

        }

        System.out.print(cnt);
    }
}