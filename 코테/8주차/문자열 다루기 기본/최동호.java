public class Solution {
    public boolean solution(String s) {
        // 문자열의 길이가 4 또는 6이 아니면 false를 반환
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        // 문자열의 모든 문자를 숫자인지 확인
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        
        // 문자열의 길이가 4 또는 6이고 모든 문자가 숫자면 true를 반환
        return true;
    }
}
