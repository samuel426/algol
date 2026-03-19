import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> stack = new Stack<>();
        
        
        int n = Integer.parseInt(br.readLine());
        
        int start = 0;
        
        for(int i = 0; i < n; i++) {
        	int cur = Integer.parseInt(br.readLine());
        	
        	if(cur > start) {
        		for(int j = start + 1; j <= cur; j++) {
        			stack.push(j);
        			sb.append('+').append('\n');
        		}
        		start = cur;
        	} else if(stack.peek() != cur) {
        		System.out.println("NO");
        		return;
        	}
        	stack.pop();
        	sb.append('-').append('\n');
        	
        }
        
        System.out.println(sb);
        
        
    }
}
