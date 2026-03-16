import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int t = 0; t < T; t++) {
			
			String[] line = br.readLine().split(" ");
			
			if(line[0].equals("front")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.peekFirst());
				}
				continue;
			}
			
			if(line[0].equals("back")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.peekLast());
				}
				continue;
			}
			
			if(line[0].equals("empty")) {
				if(deque.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				continue;
			}
			
			if(line[0].equals("size")) {
				System.out.println(deque.size());
				continue;
			}
			
			if(line[0].equals("push_back")) {
				deque.addLast(Integer.parseInt(line[1]));
				continue;
			}
			if(line[0].equals("push_front")) {
				deque.addFirst(Integer.parseInt(line[1]));
				continue;
			}
			if(line[0].equals("pop_back")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(deque.removeLast());
				continue;
			}
			if(line[0].equals("pop_front")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(deque.removeFirst());
				continue;
			}
		}
		
	}

}
