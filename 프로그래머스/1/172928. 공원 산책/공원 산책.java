class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int[] current = new int[2];
        boolean find = false;
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    current[0] = i;
                    current[1] = j;
                    find = true;
                    break;
                }
            }
            if(find) break;
        }
        
        for(int i = 0; i < routes.length; i++) {
            String[] r = routes[i].split(" ");
            String dir = r[0];
            int dis = Integer.parseInt(r[1]);
            boolean range = true;
            int[] cm = current.clone();
            int[] mv = new int[2];
            
            if("E".equals(dir)) {
                mv[1] = 1;
            } else if("S".equals(dir)) {
                mv[0] = 1;
            } else if("W".equals(dir)) {
                mv[1] = -1;
            } else {
                mv[0] = -1;
            }
            
            for(int j = 0; j < dis; j++) {
                cm[0] += mv[0];
                cm[1] += mv[1];
                if(cm[0] < 0 || cm[0] >= park.length || 
                   cm[1] < 0 || cm[1] >= park[0].length() ||
                   (park[cm[0]].charAt(cm[1]) == 'X') 
                  ) {
                    range = false;
                    break;
                }
            }
            
            if(range) {
                current = cm;
            }
        }
        
        
        return current;
    }
}