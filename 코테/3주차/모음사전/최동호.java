class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] weight = {781, 156, 31, 6, 1}; 

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = "AEIOU".indexOf(ch);
            answer += weight[i] * idx + 1; 
        }
        return answer;
    }
}