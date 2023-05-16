class Solution {
    public int solution(int n) {
        // 10진수 -> 3진수
        String[] temp = Integer.toString(n, 3).split("");
        String t = "";

        for(int i = temp.length - 1; i >= 0; i--){
            t += temp[i];
        }
        // 3진수 -> 10진수
        return Integer.parseInt(t, 3);
    }
}