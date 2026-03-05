import java.util.*;
import java.io.*;
public class Main {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 0; test_case < T; test_case++) {
			char[] orders = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			String[] line2 = line.substring(1, line.length() - 1).split(",");
			Deque<Integer> arr = new ArrayDeque<>();
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(line2[i]));
			}
			
			String answer = "[]";
			
			int dir = 0; // 0 이면 순방향 1이면 역방향
			
			for(int s = 0; s < orders.length; s++) {
				char cur = orders[s];
				
				if(cur == 'D') {
					if(arr.isEmpty()) {
						answer = "error";
						break;
					}
					
					if(dir == 0) {
						arr.removeFirst();
					} else if(dir == 1) {
						arr.removeLast();
					}
					
				} else if (cur == 'R') {
					dir = (dir + 1) % 2;
				}
				
			}
			
			if(answer.equals("error")) {
				System.out.println(answer);
				continue;
			} else if(arr.isEmpty()) {
				System.out.println(answer);
				continue;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			if (dir == 0) {
                while (!arr.isEmpty()) {
                    sb.append(arr.pollFirst());
                    if (!arr.isEmpty()) sb.append(",");
                }
            } else {
                while (!arr.isEmpty()) {
                    sb.append(arr.pollLast());
                    if (!arr.isEmpty()) sb.append(",");
                }
            }
			sb.append("]");

			
			System.out.println(sb);
		}
		
	}

}
