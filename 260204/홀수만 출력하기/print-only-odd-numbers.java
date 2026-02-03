import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        
        for(int i = 0; i < a; i++) {
            int input = Integer.parseInt(br.readLine());
            if((input % 2 == 1) && (input % 3 == 0)) {
                System.out.println(input);
            }
        }

    }
}