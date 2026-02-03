import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        for(int i = 1; i <= a; i++) {
            String num = Integer.toString(i);
            if(num.contains("3") || num.contains("6") || num.contains("9")) {
                System.out.print("0 ");
                continue;
            }
            System.out.print(i + " ");
        }

    }
}