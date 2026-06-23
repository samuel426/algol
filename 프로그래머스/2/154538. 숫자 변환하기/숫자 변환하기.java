import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        if(x == y) {
            return 0;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        int[] count = new int[y+1];
        
        Arrays.fill(count, -1);
        q.offer(x);
        count[x] = 0;
        
        while(!q.isEmpty()) {
            int current = q.poll();
            
            int[] nextNumbers = {
                current + n,
                current * 2,
                current * 3
            };
            
            for(int next : nextNumbers) {
                if(next > y) {
                    continue;
                }
                
                if(count[next] != -1) {
                    continue;
                }
                
                count[next] = count[current] + 1;
                
                if(next == y) {
                    return count[next];
                }
                q.offer(next);
            }
        }
        
        return -1;
    }
}