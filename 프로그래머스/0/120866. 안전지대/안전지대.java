class Solution {
    
    public static int r, c;
    
    public static int[] dr = {1, 1, 1, 0, 0, -1, -1, -1};
    public static int[] dc = {1, 0, -1, 1, -1, 1, 0, -1};
    
    public int solution(int[][] board) {
        int answer = 0;
        r = board.length;
        c = board[0].length;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] == 1) {
                    for(int d = 0; d < 8; d++) {
                        int mr = dr[d] + i;
                        int mc = dc[d] + j;
                        
                        if(!isIn(mr, mc)) {
                            continue;
                        }
                        if(board[mr][mc] == 1) {
                            continue;
                        }
                        board[mr][mc] = 2;
                        
                    }
                }
            }
        }
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public boolean isIn(int cr, int cc) {
        return cr >= 0 && cr < r && cc >= 0 && cc < c;
    }
}