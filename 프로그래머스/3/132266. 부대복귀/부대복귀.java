import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        // 인접 리스트
        List<Integer>[] graph = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 양방향 그래프
        for(int[] road : roads) {
            int a = road[0];
            int b = road[1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        // destination으로부터 각 지역까지의 거리
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(destination);
        distance[destination] = 0;
        
        while(!queue.isEmpty()) {
            
            int cur = queue.poll();
            
            for(int next : graph[cur]) {
                
                // 이미 방문했다면 넘어감
                if(distance[next] != -1) {
                    continue;
                }
                
                distance[next] = distance[cur] + 1;
                queue.offer(next);
            }
        }
        
        
        
        int[] answer = new int[sources.length];
        
        for(int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }
        
        return answer;
    }
}