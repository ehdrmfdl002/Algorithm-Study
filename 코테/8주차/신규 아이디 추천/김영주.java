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
        String s3 = s2;
        while(s3.contains("..")){
            s3 = s3.replace("..",".");
        }
        
        // 4단계
        if(s3.length()>0){
            if(s3.charAt(0) == '.') s3 = s3.substring(1,s3.length());
;        }
        
        if(s3.length()>0){
            if(s3.charAt(s3.length()-1) == '.') s3 = s3.substring(0,s3.length()-1);
        }
            
        // 5단계
        if(s3.length() == 0) s3="a";
        
        // 6단계
        if(s3.length()>=16){
            s3 = s3.substring(0,15);
            if(s3.charAt(s3.length()-1) == '.') s3 = s3.substring(0,s3.length()-1);
        }
        
        // 7단계
        if(s3.length()<=2){
            while(s3.length()<3) s3+=s3.charAt(s3.length()-1);
        }
        
        return s3;
        
    }
}
