import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = 0;
		num = sc.nextInt();
		int[] arr1 = new int[num];

		for(int i = 0; i < num; i++) {
			arr1[i] = sc.nextInt();
		}
		Arrays.sort(arr1);
		if (num == 1) {
			System.out.print(arr1[0] * arr1[0]);
			return;
		}
		System.out.print(arr1[0] * arr1[num-1]);
		
	}

}
