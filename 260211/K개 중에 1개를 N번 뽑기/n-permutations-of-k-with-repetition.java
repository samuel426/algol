import java.io.*;
import java.util.*;

public class Main {
    private static int a, b, numbers[];
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        a = Integer.parseInt(arr[0]);
        b = Integer.parseInt(arr[1]);

        numbers = new int[b];

        bob(0);
        
    }

    public static void bob(int cnt) { // 중복 순열
        if(cnt == b) {
            for(int i = 0; i < b; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= a; i++) {
            numbers[cnt] = i;
            bob(cnt+1);
        }
    }
}