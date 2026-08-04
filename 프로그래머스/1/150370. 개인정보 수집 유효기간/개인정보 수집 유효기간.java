import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        String[] st = today.split("\\."); 
        int[] t = new int[3];
        t[0] = Integer.parseInt(st[0]);
        t[1] = Integer.parseInt(st[1]);
        t[2] = Integer.parseInt(st[2]);
        
        for(int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] p = privacies[i].split(" ");
            String[] symd = p[0].split("\\.");
            int[] ymd = new int[3];
            ymd[0] = Integer.parseInt(symd[0]);
            ymd[1] = Integer.parseInt(symd[1]);
            ymd[2] = Integer.parseInt(symd[2]);
            
            int mon = map.get(p[1]);
            ymd[0] += mon / 12;
            ymd[1] += mon % 12;
            if(ymd[1] > 12) {
                ymd[0]++;
                ymd[1] -= 12;
            }
            if(t[0] > ymd[0]) {
                arr.add(i+1);
            } else if(t[0] == ymd[0] && t[1] > ymd[1]) {
                arr.add(i+1);
            } else if(t[0] == ymd[0] && t[1] == ymd[1] && t[2] > ymd[2]) {
                arr.add(i+1);
            } else if(t[0] == ymd[0] && t[1] == ymd[1] && t[2] == ymd[2]) {
                arr.add(i+1);
            }
        }
        
        
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}