import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(isValid(s)) {
                answer++;
            }
            
            s = s.substring(1) + s.charAt(0);
            
        }
        
        return answer;
    }
    
    boolean isValid(String s) {
        Stack<Character> ss = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                ss.push(c);
            } else {
                if(ss.isEmpty()) {
                    return false;
                }
                
                char top = ss.pop();
                
                if(c == ')' && top != '(') return false;
                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
            }
        }
        return ss.isEmpty();
    }
}