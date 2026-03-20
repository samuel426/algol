import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int ts = Integer.parseInt(br.readLine());
			
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			
			for(int t = 0; t < ts; t++) {
				String[] line = br.readLine().split(" ");
				
				int num = Integer.parseInt(line[1]);
				
				if(line[0].equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else if(line[0].equals("D")) {
					if(map.isEmpty()) continue;
					int target;
					if(num == 1) {
						target = map.lastKey();
					} else {
						target = map.firstKey();
					}
					
					int count = map.get(target);
					if(count == 1) {
						map.remove(target);
					} else {
						map.put(target, count - 1);
					}
				}
				
			}
			
			
			if(map.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append('\n');
			}
			
			
		}
		System.out.println(sb);
	}
}
