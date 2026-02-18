
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 조합 문제 
 * 
 * */
public class Main {

    static int N, R;                 
    static int[] output, arr;         
    static boolean[] used;        
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);
        arr = new int[N];
        output = new int[R];
        used = new boolean[N];
        
        for(int i = 0; i < N; i++) {
        	arr[i] = i+1;
        }
        combination(0, 1);
        
        System.out.println(sb);
    }
    
    static void combination(int depth, int start) {
    	if(depth == R) {
    		for(int i = 0; i < R; i++) {
    			sb.append(output[i]).append(" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	for(int i = start - 1; i < N; i++) {
    		if(used[i]) continue;
    		
    		used[i] = true;
    		output[depth] = arr[i];
    		combination(depth + 1, i + 1);
    		used[i] = false;
    	}
    }
}
