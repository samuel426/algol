class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int paint = section[0] + m;
        for(int i = 0; i < section.length; i++) {
            
            if(paint <= section[i]) {
                paint = section[i] + m;
                answer++;
            }
        }
        
        return answer;
    }
}