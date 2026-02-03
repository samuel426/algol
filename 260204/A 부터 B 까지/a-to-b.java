import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);

        while(a <= b) {
            System.out.print(a + " ");
            if(a % 2 == 1) {
                a *= 2;
            } else if(a % 2 == 0) {
                a += 3;
            }
        }



    }
}