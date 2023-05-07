class Solution {
    public String solution(String s) {
        
        String[] arr = s.split(" ",-1); // 문자열 뒤 공백
        String ans="";
        
        for(int i=0;i<arr.length;i++){
            String temp = "";
            for(int j=0;j<arr[i].length();j++){
                if(j%2==0) temp+=Character.toUpperCase(arr[i].charAt(j));
                else temp+=Character.toLowerCase(arr[i].charAt(j));
            }
            ans+=temp;
            if(i!=arr.length-1) ans+=" ";
        }
        
        return ans;
    }
}
