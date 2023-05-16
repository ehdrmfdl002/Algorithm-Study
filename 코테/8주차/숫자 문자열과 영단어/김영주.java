class Solution {
    static String[] number = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    public int solution(String s) {
        
        String answer="";
        String check="";
        for(int i=0;i<s.length();i++){
            if(0<=s.charAt(i)-'a' && s.charAt(i) -'a'< 26){
                check+=s.charAt(i);
                if(check.length()>=3){
                    for(int j=0;j<10;j++){
                        if(check.contains(number[j])){
                            answer+=String.valueOf(j);
                            check="";
                            break;
                        }
                    }
                }
            }else answer+=s.charAt(i);
        }
        
        return Integer.valueOf(answer);
    }
}
