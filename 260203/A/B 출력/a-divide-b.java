import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        BigDecimal a = new BigDecimal(arr[0]);
        BigDecimal b = new BigDecimal(arr[1]);

        BigDecimal result = a.divide(b, 20, RoundingMode.FLOOR);

        System.out.println(result.toPlainString());
    }
}