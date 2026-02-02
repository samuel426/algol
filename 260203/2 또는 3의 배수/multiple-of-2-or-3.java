import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        for(int i = 1; i <= a; i++) {
            if(i % 2 == 0 || i % 3 == 0) {
                System.out.print("1 ");
            }else {
                System.out.print("0 ");
            }
        }
    }
}