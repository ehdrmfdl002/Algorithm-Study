import java.util.*;

class Solution {
    static char[] alphabet={'A','E','I','O','U'};
    static ArrayList<String> list;
    public int solution(String word) {
        list = new ArrayList<>();
        int answer=0;
        
        combination(0,"");
        Collections.sort(list);
        
        return list.indexOf(word)+1;
    }
    
    public void combination(int idx, String s){
        if(idx>=5) return;
        for(int i=0;i<alphabet.length;i++){
            list.add(s+alphabet[i]);
            combination(idx+1,s+alphabet[i]);
        }
    }
}
