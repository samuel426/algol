import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int sum = 0;
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        for(int i = a; i <= b; i++) {
            if(i % 5 == 0) sum += i;
        }

        System.out.println(sum);

    }
}