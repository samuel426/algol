import java.util.*;

class Solution {
    
    static class Task {
        String name;
        int remain;
        
        Task(String name, int remain) {
            this.name = name;
            this.remain = remain;
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        Arrays.sort(plans, (a, b) -> {
            return a[1].compareTo(b[1]);
        });
        
        Deque<Task> s = new ArrayDeque<>();
        int idx = 0;

        for(int i = 0; i < plans.length - 1; i++) {
            String name = plans[i][0];
            int start = toMin(plans[i][1]);
            int play = Integer.parseInt(plans[i][2]);
            int next = toMin(plans[i + 1][1]);
            
            int gap = next - start;
            
            if(play <= gap) {
                answer[idx++] = name;
                gap -= play;
                
                while(gap > 0 && !s.isEmpty()) {
                    Task cur = s.pop();
                    
                    if(cur.remain <= gap) {
                        answer[idx++] = cur.name;
                        gap -= cur.remain;
                    } else {
                        cur.remain -= gap;
                        s.push(cur);
                        gap = 0;
                    }
                }
            } else {
                s.push(new Task(name, play - gap));
            }
            
            
        }
        
        answer[idx++] = plans[plans.length - 1][0];
        
        while(!s.isEmpty()) {
            answer[idx] = s.pop().name;
            idx++;
        }
        
        return answer;
    }
    
    public int toMin(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}