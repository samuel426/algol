import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int[] parent;
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        parent = new int[n];
        
        for(int i = 0; i < n; i++) {
        	parent[i] = i;
        }
        
        int answer = 0;
        
        for(int turn = 1; turn <= m; turn++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if(find(a) == find(b)) {
        		answer = turn;
        		break;
        	}
        	union(a, b);
        }
        
        System.out.println(answer);
    }

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) {
			parent[pb] = parent[pa];
		}
		
	}

	private static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
    
    
    
}
