class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] arrs = s.toCharArray();
        for(char arr : arrs){
            if(Character.isLowerCase(arr)) sb.append((char) ((arr -'a' + n) % 26 + 'a'));
            else if(arr == ' ') sb.append(" ");
            else sb.append((char) ((arr -'A' + n) % 26 + 'A'));
        }
        return sb.toString();
    }
}
