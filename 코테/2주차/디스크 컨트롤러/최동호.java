package programmers;
import java.util.*;
public class pro_디스크컨트롤러 {
    class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            int currentTime = 0;
            int index = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

            Arrays.sort(jobs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            while (index < jobs.length || !pq.isEmpty()) {
                if (index < jobs.length && currentTime >= jobs[index][0]) {
                    pq.offer(jobs[index++]);
                    continue;
                }

                if (!pq.isEmpty()) {
                    int[] job = pq.poll();
                    answer += currentTime - job[0] + job[1];
                    currentTime += job[1];
                } else {
                    currentTime = jobs[index][0];
                }
            }

            return answer / jobs.length;
        }
    }
}


