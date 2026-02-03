import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for(int i = 1; i <= a; i++) {

            if(i % 12 == 0) {
                cnt3++;
            } else if(i % 3 == 0) {
                cnt2++;
            } else if(i % 2 == 0) {
                cnt1++;
            }

        }

        System.out.print(cnt1 + " " + cnt2 + " " + cnt3);
    }
}