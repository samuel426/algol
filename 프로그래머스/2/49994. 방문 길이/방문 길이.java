import java.util.*;

class Matrix {
    final int[][] arr;
    
    Matrix(int[][] edge) {
        int ax = edge[0][0], ay = edge[0][1];
        int bx = edge[1][0], by = edge[1][1];
        
        if(ax < bx || (ax == bx && ay <= by)) {
            arr = new int[][] {{ax, ay}, {bx, by}};
        } else {
            arr = new int[][] {{bx, by}, {ax, ay}};
        }
        
    }
    
    @Override 
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Matrix)) return false;
        Matrix m = (Matrix) o;
        return Arrays.deepEquals(this.arr, m.arr);
    }
    
    @Override
    public int hashCode() {
        return Arrays.deepHashCode(arr);
    }
}

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        char[] input = dirs.toCharArray();
        int[] current = new int[2];
        Set<Matrix> set = new HashSet<>();
        
        for(int i = 0; i < input.length; i++) {
            int[] move = {current[0], current[1]};
            if(input[i] == 'U') {
                move[1]++;
            } else if(input[i] == 'D') {
                move[1]--;
            } else if(input[i] == 'L') {
                move[0]--;
            } else if(input[i] == 'R') {
                move[0]++;
            }
            
            if(move[0] < -5 || move[0] > 5 || move[1] < -5 || move[1] > 5) continue;
            
            int[][] edge = new int[][] {{current[0], current[1]}, {move[0], move[1]}};
            
            set.add(new Matrix(edge));
            
            current[0] = move[0];
            current[1] = move[1];
        }
        
        
        return set.size();
    }
}