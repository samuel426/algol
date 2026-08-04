class Solution {
    public long solution(int n, int[] times) {
        
        long left = 1;
        long right = (long) n * times[0];
        long answer = right;

        
        while(left <= right) {
            long mid = (left + right) / 2;
            
            long count = 0;
            
            for(int time : times) {
                count += mid / time;
                
                // 이미 n명을 처리할 수 있다면 더 계산할 필요가 없음
                if(count >= n) {
                    break;
                }
            }
            
            if(count >= n) {
                //mid분이면 가능하므로 더 짧은 시간을 탐색
                answer = mid;
                right = mid - 1;
            } else {
                // mid 분으로는 부족하므로 더 긴 시간을 탐색
                left = mid + 1;
            }
            
        }
        
        return answer;
    }
}