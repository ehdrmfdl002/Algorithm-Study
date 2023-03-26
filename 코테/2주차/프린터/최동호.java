package programmers;
import java.util.*;
public class pro_프린터 {
    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            Queue<Integer> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return priorities[o2] - priorities[o1];
                }
            });

            for (int i = 0; i < priorities.length; i++) {
                queue.offer(i);
                pq.offer(i);
            }

            while (!queue.isEmpty()) {
                int index = queue.poll();
                int priority = priorities[index];
                if (priority == priorities[pq.peek()]) {
                    pq.poll();
                    answer++;
                    if (index == location) {
                        break;
                    }
                } else {
                    queue.offer(index);
                }
            }

            return answer;
        }
    }

}
