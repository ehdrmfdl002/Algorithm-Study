import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        char[] arr = new char[strings.length];
        for(int i=0;i<strings.length;i++){
            arr[i] = strings[i].charAt(n);
        }
        
        Arrays.sort(arr);
        Arrays.sort(strings);
        
        String[] answer = new String[strings.length];
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strings));
        
        for(int i=0;i<strings.length;i++){
            for(int j=0;j<list.size();j++){
                if(list.get(j).charAt(n) == arr[i]){
                    answer[i] = list.get(j);
                    list.remove(list.get(j));
                    break;
                }
            }
        }
        
        return answer;
    }
}
