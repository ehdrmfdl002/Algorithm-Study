import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        int Max_max = Integer.MIN_VALUE;
        int Min_max = Integer.MIN_VALUE;
        
        for(int i=0;i<sizes.length;i++){
            max = Math.max(sizes[i][0],sizes[i][1]);
            min = Math.min(sizes[i][0],sizes[i][1]);
            
            Max_max = Math.max(Max_max,max);
            Min_max = Math.max(Min_max,min);
        }
        return Max_max*Min_max;
    }
}
