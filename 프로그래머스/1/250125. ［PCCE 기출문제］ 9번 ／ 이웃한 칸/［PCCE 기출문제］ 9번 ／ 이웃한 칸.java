class Solution {
    
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String cur = board[h][w];
        
        int n = board.length;
        
        for(int i = 0; i < 4; i++) {
            int r = h + dr[i];
            int c = w + dc[i];
            if(r < 0 || r >= n || c < 0 || c >= n) {
                continue;
            }
            if(board[r][c].equals(cur)) {
                answer++;
            }
        }
        
        return answer;
    }
}