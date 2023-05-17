class Solution {
    public String solution(String new_id) {
        
        // 1단계
        String s1 = new_id.toLowerCase();
        
        // 2단계
        String s2="";
        for(int i=0;i<s1.length();i++){
            if((s1.charAt(i) >= 'a' && s1.charAt(i) <= 'z')||('0'<= s1.charAt(i) && s1.charAt(i) <= '9') || (s1.charAt(i) == '-') || (s1.charAt(i) == '_') || (s1.charAt(i) == '.') ){
                s2+=s1.charAt(i);
            }
        }
        
        // 3단계
        while(s2.contains("..")){
            s2 = s2.replace("..",".");
        }
        
        // 4단계
        if(s2.length()>0){
            if(s2.charAt(0) == '.') s2 = s2.substring(1,s2.length());
;        }
        
        if(s2.length()>0){
            if(s2.charAt(s2.length()-1) == '.') s2 = s2.substring(0,s2.length()-1);
        }
            
        // 5단계
        if(s2.length() == 0) s2="a";
        
        // 6단계
        if(s2.length()>=16){
            s2 = s2.substring(0,15);
            if(s2.charAt(s2.length()-1) == '.') s2 = s2.substring(0,s2.length()-1);
        }
        
        // 7단계
        if(s2.length()<=2){
            while(s2.length()<3) s2+=s2.charAt(s2.length()-1);
        }
        
        return s2;
        
    }
}
