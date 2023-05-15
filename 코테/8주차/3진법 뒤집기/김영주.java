import java.math.*;

class Solution {
    public int solution(int n) {
        
        String s = "";
        while(n!=0){
            s+=String.valueOf(n%3);
            n/=3;
        }
        
        int idx=0;
        int tot=0;
        for(int i=s.length()-1;i>=0;i--){
            tot+=(s.charAt(i)-'0')*Math.pow(3,idx);
            idx++;
        }
        
        return tot;
    }
}
