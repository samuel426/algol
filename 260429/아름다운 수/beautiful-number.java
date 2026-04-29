import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int n, count;
    public static ArrayList<Integer> answer = new ArrayList<>();

    public static boolean isBeautiful() {
        int idx = 0;
        while(idx < n) {
            int num = answer.get(idx);
            
            if(idx + num > n) {
                return false;
            }

            for(int i = idx; i < idx + num; i++) {
                if(answer.get(i) != num) {
                    return false;
                }
            }
            idx += num;
        }
        return true;
    }

    public static void printAnswer() {
        if(isBeautiful()) {
            count++;
        }
    }

    public static void choose(int currNum) {
        if (currNum == n) {
            printAnswer();
            return;
        }

        for(int i = 1; i <= 4; i++) {
            answer.add(i);
            choose(currNum + 1);
            answer.remove(answer.size() - 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        count = 0;
        choose(0);
        System.out.println(count);
    }

}