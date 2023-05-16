class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(s.length() > 1){
            int value = 0;
            
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '0') answer[1]++;
                else value++;
            }
            
            s = Integer.toBinaryString(value);
            answer[0]++;
        }
        
        return answer;
    }
}
