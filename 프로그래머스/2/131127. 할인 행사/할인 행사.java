import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> m = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            m.put(want[i], number[i]);
        }
        
        for(int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> dm = new HashMap<>();
            
            for(int j = i; j < i + 10; j++) {
                dm.put(discount[j], dm.getOrDefault(discount[j], 0) + 1);
            }
            
            if(dm.equals(m)) {
                answer++;
            }
        }
        
        return answer;
    }
}