import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] ans = new int[2];
        
        int sum = brown+yellow;
        
        for(int i=3;i<sum;i++){
            int j = sum/i;
            
            if(sum%i==0 && j>=3){
                int center = (i-2)*(j-2);
                
                if(center == yellow){
                    ans[0] = Math.max(i,j);
                    ans[1] = Math.min(i,j);
                }
            }
        }
        return ans;
    }
}
