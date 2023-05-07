class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                ch = (char)((ch - 'a' + n) % 26 + 'a'); // 소문자 알파벳의 경우
            } else if(ch >= 'A' && ch <= 'Z') {
                ch = (char)((ch - 'A' + n) % 26 + 'A'); // 대문자 알파벳의 경우
            }
            answer.append(ch);
        }
        
        return answer.toString();
    }
}
