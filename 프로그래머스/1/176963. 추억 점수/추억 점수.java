import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for(int i = 0; i < photo.length; i++) {
            int r = 0;
            for(int j = 0; j < photo[i].length; j++) {
                r += map.getOrDefault(photo[i][j], 0);
            }
            answer[i] = r;
        }
        
        return answer;
    }
}