class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        
        String[] cache = new String[cacheSize];
        int[] index = new int[cacheSize];
        int idx = 1;
        
        for(int i = 0; i < cities.length; i++) {
            String cur = cities[i].toUpperCase();
            
            boolean tf = true;
            for(int j = 0; j < cacheSize; j++) {
                if(cache[j] == null) {
                    answer += 5;
                    cache[j] = cur;
                    tf = false;
                    break;
                } else if(cache[j].equals(cur)) {
                    answer += 1;
                    tf = false;
                    index[j] = idx;
                    break;
                }
            }
            
            if(tf) {
                int min = Integer.MAX_VALUE;
                for(int j = 0; j < cacheSize; j++) {
                    min = Math.min(min, index[j]);
                }
                for(int j = 0; j < cacheSize; j++) {
                    if(min == index[j]) {
                        cache[j] = cur;
                        index[j] = idx;
                        break;
                    }
                }
                answer += 5;
            }
            
            idx++;
        }
        
        return answer;
    }
}