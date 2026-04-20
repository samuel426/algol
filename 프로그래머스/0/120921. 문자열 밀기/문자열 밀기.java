class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        if(A.equals(B)) {
            return 0;
        }
        String cur = A;
        for(int i = 0; i < A.length(); i++) {
            cur = cur.charAt(cur.length() - 1) + cur.substring(0, cur.length() - 1);
            if(cur.equals(B)) {
                return answer = i + 1;
            }
        }
        
        return -1;
        
    }
}