import java.util.*;;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (!s.equals("1")) {
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    count++;
                }
            }
            
            s = Integer.toBinaryString(s.length() - count);
            answer[0]++;
            answer[1] += count;
        }
        
        return answer;
    }
}
