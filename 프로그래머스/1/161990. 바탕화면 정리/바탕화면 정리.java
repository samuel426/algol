class Solution {
    public int[] solution(String[] wallpaper) {
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        int sr = n, er = 0, sc = m, ec = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                char cur = wallpaper[i].charAt(j);
                if(cur == '#') {
                    sr = Math.min(sr, i);
                    sc = Math.min(sc, j);
                    er = Math.max(er, i);
                    ec = Math.max(ec, j);
                }
            }
        }
        
        int[] answer = new int[4];
        answer[0] = sr;
        answer[1] = sc;
        answer[2] = er + 1;
        answer[3] = ec + 1;
        
        return answer;
    }
}