import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {

		Stack<int[]> stack = new Stack<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int size = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		
		for(int i = 1; i <= size; i++) {
			int top = Integer.parseInt(input[i-1]);
			
			while(!stack.isEmpty()) {
				if(stack.peek()[1] >= top) {
					sb.append(stack.peek()[0] + " ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) {
				sb.append("0 ");
			}
			
			stack.push(new int[] {i,top});
		}
		
		System.out.print(sb.toString());			

	}
}
