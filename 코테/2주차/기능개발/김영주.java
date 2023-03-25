import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            q.add((int)(Math.ceil((100.0-progresses[i])/speeds[i])));
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int day = q.poll();
            int cnt=1;
            
            while(!q.isEmpty() && day >= q.peek()){
                cnt++;
                q.poll();
            }
            ans.add(cnt);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
