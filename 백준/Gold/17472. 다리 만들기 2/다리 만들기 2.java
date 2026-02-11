import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c, islandCnt;	
	static int[][] map;
	static boolean[][] isvisited;
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	static final int INF = 1_000_000_000;
	
	static class Edge {
		int a, b, w;
		Edge(int a, int b, int w) {
			this.a = a; this.b = b; this.w = w;
		}
	}
	
	static List<Edge> edges = new ArrayList<>(); // 간선 리스트
	static int[][] best; //섬 쌍 최소 다리 길이
	
	static int[] parent, rank;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr_s = br.readLine().split(" ");
		r = Integer.parseInt(arr_s[0]);
		c = Integer.parseInt(arr_s[1]);
		
		map = new int[r][c]; 
		
		for(int i = 0; i < r; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		mark();
		buildEdges();
		
		int ans = kruskal();
		System.out.println(ans);
	}

	private static int kruskal() {
		// 간선이 하나도 없으면 바로 -1 (섬이 1개면 0이 정답)
		if(islandCnt <= 1) return 0;
		if(edges.isEmpty()) return -1;
		
		// 간선 가중치 오름차순 정렬
		Collections.sort(edges, Comparator.comparingInt(e -> e.w));
		
		// 유니온 파인드 초기화: 섬 번호 2 .. islandCnt+1
		int maxId = islandCnt + 1;
		parent = new int[maxId + 1];
		rank = new int[maxId + 1];
		
		for(int i = 2; i <= maxId; i++) parent[i] = i;
		
		int total = 0;
		int used = 0; // 선택한 간선 수
		
		for(Edge e : edges) {
			if(union(e.a, e.b)) {
				total += e.w;
				used++;
				if(used == islandCnt -1) break; // MST 완성
			}
		}
		
		return (used == islandCnt - 1) ? total : -1;
	}

	private static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb) return false;
		
		// rank로 union 하기
		if(rank[pa] < rank[pb]) {
			parent[pa] = pb;
		} else if(rank[pa] > rank[pb]) {
			parent[pb] = pa;
		} else {
			parent[pb] = pa;
			rank[pa]++;
		}
		
		return true;
	}

	private static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	private static void buildEdges() {
		// 섬 번호는 2부터 (islandCnt+1 까지) 
		best = new int[islandCnt + 2][islandCnt + 2];
		for(int i = 0; i < islandCnt + 2; i++) {
			for(int j = 0; j < islandCnt + 2; j++) best[i][j] = INF;
		}
		
		//모든 섬 칸에서 4방향 직선 탐색
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] >= 2) {
					int from = map[i][j];
					for(int d = 0; d < 4; d++) {
						scan(i, j, d, from);
					}
				}
			}
		}
		//best[][] -> edges 리스트로 변환 (중복 제거 i < j만)
		edges.clear();
		for(int i = 2; i <= islandCnt + 1; i++) {
			for(int j = i + 1; j <= islandCnt + 1; j++) {
				if(best[i][j] != INF) {
					edges.add(new Edge(i, j, best[i][j]));
				}
			}
		}
	}

	private static void scan(int sr, int sc, int d, int from) {
		int nr = sr + dr[d];
		int nc = sc + dc[d];
		int len = 0;
		
		while(nr >= 0 && nr < r && nc >= 0 && nc < c) {
			if(map[nr][nc] == 0) { // 정해진 방향 그대로 가는 로직
				len++; // 바디일때만
				nr += dr[d];
				nc += dc[d];
				continue;
			}
			
			int to = map[nr][nc];
			
			if(to == from) return;
			if(len < 2) return;
			
			if(len < best[from][to]) {
				best[from][to] = len;
				best[to][from] = len;
			}
			return;
		}
		
	}

	private static void mark() {
		isvisited = new boolean[r][c];
		int id = 2; // 섬번호 2번부터 시작
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(!isvisited[i][j] && map[i][j] == 1) {
					bfsLabel(i, j, id);
					id++;
				}
			}
		}
		islandCnt = id - 2; // 섬 개수
	}

	private static void bfsLabel(int sr, int sc, int id) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sr, sc});
		isvisited[sr][sc] = true;
		map[sr][sc] = id;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0], cc = cur[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = dr[d] + cr;
				int nc = dc[d] + cc;
				
				if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
				if(isvisited[nr][nc]) continue;
				if(map[nr][nc] != 1) continue;
				
				isvisited[nr][nc] = true;
				map[nr][nc] = id;
				q.offer(new int[] {nr, nc});
			}
		}
		
	}
}
