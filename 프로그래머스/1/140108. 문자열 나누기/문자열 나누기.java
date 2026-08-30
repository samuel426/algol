class Solution {
    public int solution(String s) {
        int answer = 0;
        char cur = s.charAt(0);
        int same = 1;
        int diff = 0;
        for(int i = 1; i < s.length(); i++) {
            
            if(cur == s.charAt(i)) {
                same++;
            } else {
                diff++;
            }
            if(same == diff) {
                
                answer++;
                if(i + 1 < s.length()) {
                    cur = s.charAt(i + 1);
                    same = 0;
                    diff = 0;
                }

            }
        }
        if(same != diff) {
            answer++;
        }
        
        return answer;
    }
}