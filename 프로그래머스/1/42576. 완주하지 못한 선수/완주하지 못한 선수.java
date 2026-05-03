import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> m = new HashMap<>();
        
        for(int i = 0; i < participant.length; i++) {
            String cur = participant[i];
            m.put(cur, m.getOrDefault(cur, 0) + 1);
        }
        
        for(int i = 0; i < completion.length; i++) {
            String cur = completion[i];
            m.put(cur, m.getOrDefault(cur, 0) - 1);
            if(m.get(cur) == 0) {
                m.remove(cur);
            }
        }
        String answer = "";
        
        for(String key : m.keySet()) {
            answer = key;
        }        
        
        return answer;
    }
}