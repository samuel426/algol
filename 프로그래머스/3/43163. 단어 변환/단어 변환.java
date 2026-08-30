import java.util.*;

class Solution {
    
    static class Node {
        
        String word;
        int count;
        
        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
        
    }
    
    
    public int solution(String begin, String target, String[] words) {
        
        boolean[] visited = new boolean[words.length];
        Queue<Node> q = new LinkedList<>();
        
        q.offer(new Node(begin, 0));
        
        while(!q.isEmpty()) {
            
            Node cur = q.poll();
            
            if(cur.word.equals(target)) {
                return cur.count;
            }
            
            for(int i = 0; i < words.length; i++) {
                if(visited[i]) {
                    continue;
                }
                
                if(canChange(cur.word, words[i])) {
                    visited[i] = true;
                    q.offer(new Node(words[i], cur.count + 1));
                }
            }
            
        }
        
        
        return 0;
    }
    
    private boolean canChange(String a, String b) {
        int diff = 0;
        
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            
            if(diff > 1) return false;
        }
        
        return diff == 1;
    }
}