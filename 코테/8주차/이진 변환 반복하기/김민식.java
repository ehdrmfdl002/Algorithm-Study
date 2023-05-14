class Solution {
    public int[] solution(String s) {
        int zero = 0;
        int cnt = 0;
        while(true){
            if(s.equals("1")) break;
            cnt++;
            zero += s.chars().filter(i -> i == '0').count();
            s = s.replaceAll("0", "");
            s = Integer.toBinaryString(s.length());
        }
        return new int[] {cnt, zero};
    }
}