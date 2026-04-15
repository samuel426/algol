class Solution {
    public String[] solution(String[] quiz) {
        
        String[] answer = new String[quiz.length];
        
        for(int i = 0; i < quiz.length; i++) {
            String[] cur = quiz[i].split(" ");
            int X = Integer.parseInt(cur[0]);
            int Y = Integer.parseInt(cur[2]);
            int Z = Integer.parseInt(cur[4]);
            
            boolean result = false;
            if(cur[1].equals("+")) {
                if(X + Y == Z) {
                    result = true;
                }
            } else {
                if(X - Y == Z) {
                    result = true;
                }
            }
            
            if(result) {
                answer[i] = "O";
            } else {
                answer[i] = "X";
            }
            
        }
        
        return answer;
    }
}