class Solution {
    public int[] solution(int[][] edges) {
        
        // 문제의 정점 범위 최대 범위에 맞춰 적기
        int maxNode = 0;
        
        for(int[] edge : edges) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }
        
        int[] in = new int[maxNode + 1];
        int[] out = new int[maxNode + 1];
        
        // 진입차수, 전출차수 계산
        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            out[from]++;
            in[to]++;
            
        }
        
        int created = 0;
        int stick = 0;
        int eight = 0;
        
        for(int i = 1; i <= maxNode; i++) {
            
            // 생성한 정점
            if(in[i] == 0 && out[i] >= 2) {
                created = i;
            }
            
            // 막대그래프의 끝점
            if(out[i] == 0 && in[i] > 0) {
                stick++;
            }
            
            // 8자 그래프의 중심
            if(in[i] >= 2 && out[i] >= 2) {
                eight++;
            }
        }
        
        int donut = out[created] - stick - eight;
        return new int[]{created, donut, stick, eight};
    }
}