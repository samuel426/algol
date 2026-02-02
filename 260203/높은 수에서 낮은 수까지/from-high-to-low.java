import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int a = Integer.parseInt(arr[1]);
        int b = Integer.parseInt(arr[0]);
        int[] input = {a, b};
        Arrays.sort(input);
        for(int i = input[1]; i >= input[0]; i--) {
            System.out.print(i + " ");
        }
    }
}