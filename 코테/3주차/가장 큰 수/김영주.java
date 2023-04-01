import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            str[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });
        
        if(str[0].equals("0")) return "0";
        return String.join("",str);
    }
}
