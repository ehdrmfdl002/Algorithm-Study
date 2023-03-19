import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
       ArrayList<Integer> list = new ArrayList<>();
       list.add(arr[0]);
       for(int i=1;i<arr.length;i++){
           if(arr[i]!=arr[i-1]) list.add(arr[i]);
       }
       
       int[] ans = new int[list.size()];
       for(int i=list.size()-1;i>=0;i--){
           ans[i] = list.get(i);
       }
        
        return ans;
    }
}
