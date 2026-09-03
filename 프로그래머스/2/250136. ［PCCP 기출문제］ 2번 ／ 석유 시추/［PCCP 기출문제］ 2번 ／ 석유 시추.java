import java.util.*;

class Solution {
    
    int n, m;
    boolean[][] visited;
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        
        n = land.length;
        m = land[0].length;
        
        visited = new boolean[n][m];
        
        int[] oil = new int[m];
        
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(land[r][c] == 1 && !visited[r][c]) {
                    bfs(r, c, land, oil);
                }
            }
        }
        
        int answer = 0;
        
        for(int value : oil) {
            answer = Math.max(answer, value);
        }
        
        return answer;
    }
    
    private void bfs(int startR, int startC, int[][] land, int[] oil) {
        Queue<int[]> queue = new ArrayDeque<>();
        Set<Integer> columns = new HashSet<>();
        
        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;
        
        int size = 0;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            
            size++;
            
            columns.add(c);
            
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                
                if(visited[nr][nc]) {
                    continue;
                }
                
                if(land[nr][nc] == 0) {
                    continue;
                }
                
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
                
            }
        }
        
        for(int column : columns) {
            oil[column] += size;
        }
    }
}