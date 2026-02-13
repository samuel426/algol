import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int part_size, total, answer = 1_000_000_000;
	private static int[] peoples;
	private static List<int[]> edges;
	private static boolean[] inA;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		part_size = Integer.parseInt(br.readLine());
		peoples = new int[part_size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		total = 0;
		
		for(int i = 0; i < part_size; i++) {
			peoples[i] = Integer.parseInt(st.nextToken());
			total += peoples[i];
		}
		
		edges = new ArrayList<>();
		for(int i = 0; i < part_size; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			if(size == 0) {
				edges.add(new int[0]);
				continue;
			}
			int[] edge = new int[size];
			for(int j = 0; j < size; j++) {
				edge[j] = Integer.parseInt(st.nextToken()) - 1;
			}
			edges.add(edge);
		}
		
		inA = new boolean[part_size];
		
		for(int k = 1; k <= part_size / 2; k++) {
			comb(0, 0, k);
		}
		
		System.out.println(answer == 1_000_000_000 ? -1 : answer);
	}
	
	private static void comb(int idx, int picked, int target) {
		if (picked == target) {
			// A/B 둘다 연결 이어야 함
			if(!isConnected(inA, true)) return;
			if(!isConnected(inA, false)) return;
			
			int sumA = 0;
			for(int i = 0; i < part_size; i++) {
				if(inA[i]) sumA += peoples[i];
			}
			
			int sumB = total - sumA;
			int diff = Math.abs(sumA - sumB);
			if(diff < answer) answer = diff;
			return;
		}
		if(idx == part_size) return;
		
		// 남은 걸 다 골라도 target 못 채우면 컷
		if(picked + (part_size - idx) < target) return;
		
		// idx를 A에 포함
		inA[idx] = true;
		comb(idx + 1, picked + 1, target);
		
		// idx를 B에 포함
		inA[idx] = false;
		comb(idx + 1, picked, target);
	}
	
	private static boolean isConnected(boolean[] inA, boolean targetGroup) {
		// targetGroup == true -> A 연결 체크
		// targetGroup == false -> B 연결 체크
		
		int start = -1;
		int need = 0;
		for(int i = 0; i < part_size; i++) {
			if(inA[i] == targetGroup) {
				need++;
				if(start == -1) start = i;
			}
		}
		
		// comb에서 A는 항상 1개 이상이고, B도 자동으로 1개 이상이지만 혹시나 해서
		if(need == 0) return false;
		
		boolean[] visited = new boolean[part_size];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		q.add(start);
		
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int nxt : edges.get(cur)) {
				if (visited[nxt]) continue;
				if(inA[nxt] != targetGroup) continue;
				visited[nxt] = true;
				q.add(nxt);
				cnt++;
			}
		}
		
		return cnt == need;
	}
}
