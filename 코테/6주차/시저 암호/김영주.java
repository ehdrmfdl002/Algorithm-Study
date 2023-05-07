import java.util.*;

class Solution {
    public String solution(String s, int n) {
        
        String ans="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' ') ans+=" ";
            else{
                if(Character.isUpperCase(s.charAt(i))) ans+=(char)((s.charAt(i)-'A'+n)%26+'A');
                else if(Character.isLowerCase(s.charAt(i))) ans+=(char)((s.charAt(i)-'a'+n)%26+'a');
            }
        }
        return ans;
    }
}
