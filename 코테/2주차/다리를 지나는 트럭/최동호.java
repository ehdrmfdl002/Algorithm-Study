package programmers;
import java.util.*;
public class pro_다리를지나가는트럭 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            int current_weight = 0;
            Queue<Integer> bridge = new ArrayDeque<>();

            for(int i = 0; i < bridge_length; i++) {
                bridge.offer(0);
            }

            for(int i = 0; i < truck_weights.length; i++) {
                int truck_weight = truck_weights[i];

                while(true) {
                    int head = bridge.poll();
                    current_weight -= head;

                    if(current_weight + truck_weight <= weight) {
                        bridge.offer(truck_weight);
                        current_weight += truck_weight;
                        answer++;
                        break;
                    } else {
                        bridge.offer(0);
                        answer++;
                    }
                }
            }

            answer += bridge_length;

            return answer;
        }
    }
}
