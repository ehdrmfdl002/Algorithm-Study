import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
       int ans=0; // 모든 트럭이 다리를 통과하는데 걸린 시간
       int temp_weight=0; // 현재 다리 트럭 무게 총 합
       int idx=0; // 트럭 무게를 참조할 변수
        
       Queue<Integer> q = new LinkedList<>();
       while(true){
           if(idx == truck_weights.length) break; // 마지막 트럭이 다리에 올라가면 벗어남
           if(q.size() == bridge_length) // 다리에 있는 트럭이 끝에 도달하면, 도달한 트럭의 무게를 현재 다리의 트럭 무게의 총합에 더한다.
               temp_weight-=q.poll();
           // 현재 다리의 트럭 무게 총합+ 다리에 올라가야 하는 트럭의 무게> 다리의 하중
           else if(temp_weight+truck_weights[idx]>weight){ 
               q.offer(0);
               ans++;
           }else{
               q.offer(truck_weights[idx]);
               temp_weight+=truck_weights[idx];
               ans++;
               idx++;
           }
       }
        // 마지막 트럭이 다리에 올라간 상태에서 다리의 길이를 더해주면, 모든 트럭이 통과하는데 걸린 시간
        return ans+bridge_length;
    }
}
