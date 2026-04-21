class Solution {
    public int solution(int a, int b) {
        int div = gcd(a, b);
        b /= div;
        while(b % 2 == 0) {
            b /= 2;
        }
        while(b % 5 == 0) {
            b /= 5;
        }
        
        return b == 1 ? 1 : 2;
    }
    
    public static int gcd(int a, int b) {
        
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
}