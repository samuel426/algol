
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int[] arr = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		for(int i = 0; i < N+1; i++) {
			arr[i] = i;
		}
		
		int idx = 0;
		int start = 2;
		int answer = 0;
		while(idx != K) {
			for(int i = 1; i * start < N + 1; i++) {
				if(!(visited[i * start])) {
					idx++;
					visited[i * start] = true;
				}
				if(idx == K) {
					answer = arr[i * start];
					break;
				}
				
			}
			if(idx == K) {
				break;
			}
			start++;
		}
		System.out.println(answer);
	}

}
