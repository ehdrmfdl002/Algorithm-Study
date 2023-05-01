import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int idx = 0;
        // List<Integer> list = Arrays.stream(people)
        //                 .boxed()
        //                 .collect(Collectors.toList());
        // Collections.sort(list);
        Arrays.sort(people);
        
        for(int i = people.length - 1; i >= idx; i--){
            // if(list.get(i) + list.get(idx) <= limit){
            if(people[i] + people[idx] <= limit){
                answer++;
                idx++;
            }else{
                answer++;
            }
        }
        
        return answer;
    }
}