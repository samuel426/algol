import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);

        int start = 1;
        while(start <= a) {
            if(start % b == 0) {
                System.out.println(1);
                start++;
                continue;
            }
            System.out.println(0);
            start++;
        }
    }
}