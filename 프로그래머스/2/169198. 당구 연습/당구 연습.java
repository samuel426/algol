class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int bx = balls[i][0];
            int by = balls[i][1];

            int best = Integer.MAX_VALUE;

            // 1) left wall: (-bx, by)
            if (!(startY == by && bx < startX)) {
                best = Math.min(best, dist2(startX, startY, -bx, by));
            }

            // 2) right wall: (2m - bx, by)
            if (!(startY == by && bx > startX)) {
                best = Math.min(best, dist2(startX, startY, 2 * m - bx, by));
            }

            // 3) bottom wall: (bx, -by)
            if (!(startX == bx && by < startY)) {
                best = Math.min(best, dist2(startX, startY, bx, -by));
            }

            // 4) top wall: (bx, 2n - by)
            if (!(startX == bx && by > startY)) {
                best = Math.min(best, dist2(startX, startY, bx, 2 * n - by));
            }

            answer[i] = best;
        }

        return answer;
    }

    private int dist2(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        return dx * dx + dy * dy;
    }
}