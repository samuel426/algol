import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        float[] nums = new float[num];
        for (int i = 0; i < num; i++) {
            nums[i] = sc.nextInt(); // 입력받은 숫자 배열에 저장
        }

        float max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max){
                max = nums[i];
            }
        }

        float total = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (nums[i]/max)*100;
            total += nums[i];
        }
        System.out.println(total/nums.length);
    }

}