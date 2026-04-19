import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int n = number.length;
        Arrays.sort(number);
        for(int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            
            while(left < right) {
                int sum = number[i] + number[left] + number[right];
                
                if(sum == 0) {
                    // 같은 값 처리
                    if(number[left] == number[right]) {
                        int count = right - left + 1;
                        answer += count * (count - 1) / 2;
                        break;
                    } else {
                        int leftVal = number[left];
                        int rightVal = number[right];
                        int leftCount = 0;
                        int rightCount = 0;
                        
                        while(left <= right && number[left] == leftVal) {
                            left++;
                            leftCount++;
                        }
                        
                        while(right >= left && number[right] == rightVal) {
                            right--;
                            rightCount++;
                        }
                        answer += leftCount * rightCount;
                    }
                    
                    
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        
        return answer;
    }
}