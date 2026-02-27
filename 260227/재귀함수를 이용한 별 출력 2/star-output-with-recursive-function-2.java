import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        flower(n);

    }


    public static void flower(int cnt) {
        if(cnt < 1) return;
        String s = "";
        for(int i = 0; i < cnt; i++) {
            s += "* ";
        }
        System.out.println(s);
        flower(cnt -1);
        s = "";
        for(int i = 0; i < cnt; i++) {
            s += "* ";
        }
        System.out.println(s);
    }
}