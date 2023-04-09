class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for(int i = (int)Math.sqrt(total); i >= 1; i--) {
            if(total % i == 0) {
                int j = total / i;
                if((i - 2) * (j - 2) == yellow) {
                    answer[0] = j;
                    answer[1] = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}