import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        for(int i=0;i<phone_book.length;i++){
            set.add(phone_book[i]);
        }
        
        for(String phone:phone_book){
            for(int j=1;j<phone.length();j++){
                if(set.contains(phone.substring(0,j))) return false;
            }
        }
        return true;
    }
}
