import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        while(a <= 100) {
            if(a >= 90) {
                System.out.print("A ");
            } else if(a >= 80 && a <90) {
                System.out.print("B ");
            } else if(a >= 70 && a <80) {
                System.out.print("C ");
            } else if(a >= 60 && a <70) {
                System.out.print("D ");
            }
            a++;
        }
    }
}