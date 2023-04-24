import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int ans = n-lost.length;
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i] == reserve[j]){
                    ans++;
                    lost[i] = reserve[j] = -1;
                    break;
                }
            }
        }
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i] == reserve[j]-1 || lost[i] == reserve[j]+1){
                    ans++;
                    reserve[j]=-1;
                    break;
                }
            }
        }
        return ans;
    }
}
