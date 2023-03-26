import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) q.add(i);
        while(!q.isEmpty()){
            int n = q.poll();
            boolean flag = false;
            for(int i = 0; i < priorities.length; i++){
                if(flag) break;
                if(i != n && priorities[i] != -1 && priorities[n] < priorities[i]) flag = !flag;
            }
            if(flag) q.add(n);
            else {
                list.add(n);
                if(n == location) return list.size();
                priorities[n] = -1;
            }
        }
        return answer;
    }
}