import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] splits = s.split("");
        int idx = -1;
        for(String split : splits){
            idx++;
            if(split.equals(" ")){
                answer += " ";
                idx = -1;
            }
            else if(idx % 2 == 0) answer += split.toUpperCase();
            else answer += split.toLowerCase();
        }
        return answer;
    }
}