class Solution {
    private int n;
    private boolean[] colUsed;
    private boolean[] diag1Used;
    private boolean[] diag2Used;
    private int answer;

    public int solution(int n) {
        this.n = n;
        this.colUsed = new boolean[n];
        this.diag1Used = new boolean[2 * n - 1];
        this.diag2Used = new boolean[2 * n - 1];
        this.answer = 0;
        backtrack(0);
        return answer;
    }

    private void backtrack(int row) {
        if(row == n) {
            answer++;
            return;
        }
        for(int col = 0; col < n; col++) {
            int d1 = row - col + (n - 1);
            int d2 = row + col;

            if(colUsed[col] || diag1Used[d1] || diag2Used[d2]) continue;

            colUsed[col] = true;
            diag1Used[d1] = true;
            diag2Used[d2] = true;

            backtrack(row+1);

            colUsed[col] = false;
            diag1Used[d1] = false;
            diag2Used[d2] = false;
        }
    }

    
}