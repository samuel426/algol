class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int t = 10;
        String b = Integer.toString(t, 2);
        System.out.println(b);
        
        for(int i = 0; i < n; i++) {
            int t1 = arr1[i];
            int t2 = arr2[i];
            String cur1 = Integer.toString(t1, 2);
            String cur2 = Integer.toString(t2, 2);
            if(cur1.length() < n) {
                while(cur1.length() != n) {
                    cur1 = " " + cur1;
                }
            }
            if(cur2.length() < n) {
                while(cur2.length() != n) {
                    cur2 = "0" + cur2;
                }
            }
            String fin = "";
            for(int j = 0; j < n; j++) {
                if(('1' == cur1.charAt(j)) || ('1' == cur2.charAt(j))) {
                    fin += "#";
                } else {
                    fin += " ";
                }
            }
            
            answer[i] = fin;
        }
        
        return answer;
    }
}