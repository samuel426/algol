class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] nums = {"zero", "one", "two", "three", "four",
                        "five", "six", "seven", "eight", "nine"};
        String a = "";
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                a += c;
            } else {
                String cur = s.substring(i);
                for(int j = 0; j < 10; j++) {
                    if(cur.startsWith(nums[j])) {
                        a += Integer.toString(j);
                    }
                }
            }
        }
        answer = Integer.parseInt(a);
        return answer;
    }
}