import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int t = 1; t <= 10; t++) {
			
			int size = Integer.parseInt(br.readLine());
			String[] original = br.readLine().split(" ");
			int order_num = Integer.parseInt(br.readLine());
			String[] order = br.readLine().split(" ");
			
			LinkedList<String> list = new LinkedList<>();
			for(String s : original) {
				list.add(s);
			}
			
			int order_cnt = 0;
			int idx = 0;
			while(order_cnt < order_num) {
				String input = order[idx];
				if(input.equals("I")) {
					order_cnt++;
					idx++;
					int where = Integer.parseInt(order[idx]);
					idx++;
					int input_nums_size = Integer.parseInt(order[idx]);
					for(int i = 0; i < input_nums_size; i++) {
						idx++;
						list.add(where, order[idx]);
						where++;
					}
					idx++;
				} else if(input.equals("D")) {
					order_cnt++;
					idx++;
					int where = Integer.parseInt(order[idx]);
					idx++;
					int delete_nums_size = Integer.parseInt(order[idx]);
					for(int i = 0; i < delete_nums_size; i++) {
						list.remove(where);
					}
                    idx++;
				}
			}
			
			System.out.print("#" + t);
			for(int i = 0; i < 10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
		
		
		
		
	}

}
