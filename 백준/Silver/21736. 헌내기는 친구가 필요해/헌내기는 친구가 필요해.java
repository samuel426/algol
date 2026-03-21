import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        char[][] map = new char[R][C];
        boolean[][] isvisited = new boolean[R][C];
        int[] start = new int[2];
        for(int i = 0; i < R; i++) {
        	
        	char[] line = br.readLine().toCharArray();
        	for(int j = 0; j < C; j++) {
        		map[i][j] = line[j];
        		if(map[i][j] == 'I') {
        			start[0] = i;
        			start[1] = j;
        		}
        	}
        }
        
        
        
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(start);
        isvisited[start[0]][start[1]] = true;
        int answer = 0;
        while(!dq.isEmpty()) {
        	int[] cur = dq.poll();
        	int r = cur[0];
        	int c = cur[1];
        	
        	for(int d = 0; d < 4; d++) {
        		int mr = r + dr[d]; 
        		int mc = c + dc[d];
        		
        		if(mr >= 0 && mr < R && mc >= 0 && mc < C && (!isvisited[mr][mc])) {
        			if(map[mr][mc] == 'P') {
        				answer++;
        				dq.offer(new int[] {mr, mc});
        				isvisited[mr][mc] = true;
        			} else if(map[mr][mc] == 'O') {
        				dq.offer(new int[] {mr, mc});
        				isvisited[mr][mc] = true;
        			} else if(map[mr][mc] =='X') {
        				isvisited[mr][mc] = true;
        			}
        		}
        		
        	}
        	
        }
       
        if(answer == 0) {
        	System.out.println("TT");
        } else {
        	System.out.println(answer);
        }

	}

}
