class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        int idx1 = 0;
        int idx2 = 0;
        String c1 = "";
        String c2 = "";
        for(int i = 0; i < goal.length; i++) {
            if(idx1 < cards1.length) {
                c1 = cards1[idx1];
            }
            if(idx2 < cards2.length) {
                c2 = cards2[idx2];
            }
            if(c1.equals(goal[i])) {
                idx1++;
            } else if(c2.equals(goal[i])) {
                idx2++;
            } else {
                break;
            }
            if(i == goal.length - 1) {
                answer = "Yes";
            }
        }
        
        
        return answer;
    }
}