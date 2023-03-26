import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : scoville){
            pq.add(num);
        }

        while(true){
            if(pq.isEmpty() || pq.size() == 1){
                if(pq.peek() >= K) break;
                answer = -1;
                break;
            }
            if(pq.peek() >= K) break;
            answer++;
            int first = pq.poll();
            pq.add(first + pq.poll() * 2);
        }
        return answer;
    }
}