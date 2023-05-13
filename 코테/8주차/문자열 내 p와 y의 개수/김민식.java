class Solution {
    boolean solution(String s) {
        s = s.toUpperCase();
        int P = 0;
        int Y = 0;
        String[] split = s.split("");
        for(int i = 0; i < s.length(); i++){
            if(split[i].equals("P")) P++;
            else if(split[i].equals("Y")) Y++;
        }
        return P == Y ? true : false;
    }
}