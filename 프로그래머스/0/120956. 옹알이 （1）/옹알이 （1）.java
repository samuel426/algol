class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] sounds = {"aya", "ye", "woo", "ma"};
        
        for(String word : babbling) {
            boolean[] used = new boolean[4];
            int idx = 0;
            boolean possible = true;
            
            while(idx < word.length()) {
                boolean matched = false;
                
                for(int i = 0; i < sounds.length; i++) {
                    String sound = sounds[i];
                    
                    if(!used[i] && word.startsWith(sound, idx)) {
                        used[i] = true;
                        idx += sound.length();
                        matched = true;
                        break;
                    }
                }
                
                if(!matched) {
                    possible = false;
                    break;
                }
                
            }
            if(possible) {
                answer++;
            }
        }
        
        
        return answer;
    }
}