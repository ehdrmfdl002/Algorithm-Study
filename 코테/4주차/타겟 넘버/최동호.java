import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        
        for (int i = 0; i < numbers.length; i++) {
            int size = q.size();
            
            for (int j = 0; j < size; j++) {
                int num = q.poll();
                q.offer(num + numbers[i]);
                q.offer(num - numbers[i]);
            }
        }
        
        int answer = 0;
        while (!q.isEmpty()) {
            if (q.poll() == target) {
                answer++;
            }
        }
        
        return answer;
    }
}
