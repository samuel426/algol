class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] mon = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        String[] re = new String[] {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        for(int i = 1; i < a; i++) {
            b += mon[i - 1];
        }
        b = (b - 1) % 7;
        answer = re[b];
            
            
            
        return answer;
    }
}