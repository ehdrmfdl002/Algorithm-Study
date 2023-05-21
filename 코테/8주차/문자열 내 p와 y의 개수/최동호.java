public class Solution {
    public boolean solution(String s) {
        s = s.toLowerCase(); // 문자열을 소문자로 변환
        int countP = 0;
        int countY = 0;

        for (char c : s.toCharArray()) {
            if (c == 'p') {
                countP++;
            } else if (c == 'y') {
                countY++;
            }
        }

        return countP == countY;
    }
}
