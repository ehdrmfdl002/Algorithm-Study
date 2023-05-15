class Solution {
    boolean solution(String s) {
        int pSum=0;
        int ySum=0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P') pSum++;
            else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') ySum++;
        }
        
        if((pSum == ySum) || (pSum == 0 && ySum == 0)) return true;
        else return false;
    }
}
