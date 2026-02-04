import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int num = 1;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i <26; i++) {
            String c = String.valueOf((char)('A' + i));
            map.put(c, num++);
        }
        
        for(int i = 0; i < msg.length(); i++) {
            int j = msg.length() - i;
            while(j > 0 && !map.containsKey(msg.substring(i, i+j))) {
                j--;
            }
            
            String w = msg.substring(i, i + j);
            list.add(map.get(w));
            
            if(i + j < msg.length()) {
                String wc = msg.substring(i, i + j + 1);
                map.put(wc, num++);
            } else {
                break;
            }
            i += (j -1);
        }
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}