/*
 * 15572 kb
 * 136 kb
 * 난이도 2.5/10
 * 피드백 : 수업시간에 한 내용이라 간단했다.
 * 
 * */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] input = new int[N];
		String[] input_s = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(input_s[i]);
		}
		
		Arrays.sort(input);
		
		int start, end, sum;
		start=end=sum=0;
		end = N-1;
		
		int[] answer = new int[2];
		int min = Integer.MAX_VALUE;
		while(start < end) {
			sum = input[start] + input[end];
			if(sum < 0) {
				if(Math.abs(sum) < min) {
					min = Math.abs(sum);
					answer[0] = input[start];
					answer[1] = input[end];					
				}
				start++;				
			}else if(sum > 0) {
				if(Math.abs(sum) < min) {
					min = Math.abs(sum);
					answer[0] = input[start];
					answer[1] = input[end];
				}
				end--;
			}else if(sum == 0) {
				answer[0] = input[start];
				answer[1] = input[end];
				break;
			}
		}
		System.out.println(answer[0] + " " + answer[1]);
		
	}

}
