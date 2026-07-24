import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] ==b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        int currentTime = 0;
        int index = 0;
        int count = 0;
        int totalTime = 0;
        
        while(count < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= currentTime) {
                pq.offer(jobs[index]);
                index++;
            }
            
            if(!pq.isEmpty()) {
                int[] job = pq.poll();
                
                currentTime += job[1];
                totalTime += currentTime - job[0];
                count++;
            } else {
                currentTime = jobs[index][0];
            }
        }
        
        
        return totalTime / jobs.length;
    }
}