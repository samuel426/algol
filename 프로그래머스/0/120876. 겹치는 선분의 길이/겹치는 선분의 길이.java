class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] line = new int[202];
        
        for(int i = 0; i < lines.length; i++) {
            int start = lines[i][0] + 100;
            int end = lines[i][1] + 100;
            
            for(int s = start; s < end; s++) {
                line[s]++;
            }
            
        }
        for(int i = 0; i < line.length; i++) {
            if(line[i] >= 2) {
                answer++;
            }
        }
        
        return answer;
    }
}