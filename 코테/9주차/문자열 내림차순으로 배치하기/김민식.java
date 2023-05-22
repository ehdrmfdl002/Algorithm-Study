import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] split = s.split("");
        Arrays.sort(split, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String str : split) sb.append(str);
        return sb.toString();
    }
}