import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
       ArrayList<Integer> list = new ArrayList<>();
       int start=0;
       int standard=0;
       while(true){
         if(start == prices.length) break;
         standard = prices[start];
         int cnt=1;
         for(int i=start+1;i<prices.length;i++){
             if(standard>prices[i] || i == prices.length-1){
                 list.add(cnt);
                 break;
             }
             cnt++;
          }
          start++;
       }
     list.add(0);
     return list.stream().mapToInt(i->i).toArray();
    }
}
