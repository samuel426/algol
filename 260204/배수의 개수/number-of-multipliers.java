import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int cnt3 = 0;
        int cnt5 = 0;
        for(int i = 0; i < 10; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input % 3 == 0) {
                cnt3++;
            } 
            if (input % 5 == 0) {
                cnt5++;
            }
        }
        System.out.print(cnt3 + " " + cnt5);

    }
}