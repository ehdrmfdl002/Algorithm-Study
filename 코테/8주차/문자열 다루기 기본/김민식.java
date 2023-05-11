class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        if(s.length() == 4 || s.length() == 6){
            for(int i = 0; i < 10; i++) s = s.replaceAll(num[i], "");
            if(s.length() > 0) return false;
            return true;
        }
        return answer;
        
    }
}