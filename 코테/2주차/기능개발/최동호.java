
import java.util.*;
public class 기능개발 {
        public int[] solution(int[] progresses, int[] speeds) {
            ArrayList<Integer> list = new ArrayList<>();
            Queue<Integer> q = new ArrayDeque<>();


            for(int i = 0; i < progresses.length; i++){
                int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
                q.offer(day);
            }

            int cnt = 1;
            int start = q.poll();

            while(!q.isEmpty()){
                int next = q.poll();

                if(start >= next)
                    cnt++;
                else {
                    list.add(cnt);
                    cnt = 1;
                    start = next;
                }
            }

            list.add(cnt);

            int [] answer = new int[list.size()];

            for(int i = 0; i < answer.length; i++){
                answer[i] = list.get(i);
            }


            return answer;
        }
}

