import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Integer[] tmp = new Integer[citations.length];

        for(int i = 0; i < citations.length; i++){
             tmp[i] = Integer.valueOf(citations[i]);
        }
        
        Arrays.sort(tmp, Collections.reverseOrder());

       for(int i = 0; i < tmp.length; i++){
            int h = i + 1;

            if(tmp[i] < h){
                break;
            }
            answer = h;
        }

        return answer;
    }
}