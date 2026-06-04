class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        if(isParelled(dots[0], dots[1], dots[2], dots[3])) {
            answer = 1;
        }
        
        if(isParelled(dots[0], dots[2], dots[1], dots[3])) {
            answer = 1;
        }
        
        if(isParelled(dots[0], dots[3], dots[1], dots[2])) {
            answer = 1;
        }
        
        
        return answer;
    }
    
    public boolean isParelled(int[] a, int[] b, int[] c, int[] d) {
        int dx1 = b[0] - a[0];
        int dy1 = b[1] - a[1];
        
        int dx2 = d[0] - c[0];
        int dy2 = d[1] - c[1];
        
        return dy1 * dx2 == dy2 * dx1;
    }
}