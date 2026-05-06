import java.util.*;
import java.io.*;

public class Main {

    public static int MAX_N = 1002;

    public static void main(String[] args) throws Exception{
        int[] dp = new int[MAX_N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        dp[1] = 1;
        dp[2] = 2;

        

        for(int i = 3; i <= n; i++)
            dp[i] = (dp[i - 1] +  dp[i - 2]) % 10007;

        System.out.println(dp[n]);

    }
}