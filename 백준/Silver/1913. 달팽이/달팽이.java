import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int where = Integer.parseInt(br.readLine());
		
		int[][] input = new int[size][size];
	
		int[] current = {size/2 , size/2};
		int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		int d = 0;
		input[current[0]][current[1]] = 1;   // 중앙에 1
		current[0] += dir[d][0];             // 처음만 위로 한 칸 이동
		current[1] += dir[d][1];
		for(int i = 2; i <= size * size; i++) {
			input[current[0]][current[1]] = i;
			if (i == size * size) break;
			// x, y 좌표 옮김
			int nd = (d + 1) % 4;
			int nr = dir[nd][0] + current[0];
			int nc = dir[nd][1] + current[1];
			if(0 <= nr && nr < size && 0 <= nc && nc < size && input[nr][nc] == 0) { 
				d = nd;
			}
			
			current[0] += dir[d][0];
			current[1] += dir[d][1];
		}
		
		int[] answer = new int[2];
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < size; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < size; j++) {
				sb.append(input[i][j]).append(' ');
				if(input[i][j] == where) {
					answer[0] = i+1;
					answer[1] = j+1;
				}
			}
			sb.append('\n');
			bw.write(sb.toString());
		}
		
		bw.write(answer[0] + " " + answer[1] + "\n");
		bw.flush();
	}
}
