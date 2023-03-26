import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int bridgeWeight = 0;
        for(int tw : truck_weights){
            while(true){
                if(q.isEmpty()){
                    q.add(tw);
                    bridgeWeight += tw;
                    answer++;
                    break;
                }else if(q.size() == bridge_length){
                    bridgeWeight -= q.poll();
                }else {
                    if(bridgeWeight + tw > weight){
                        q.add(0);
                        answer++;
                    }else{
                        q.add(tw);
                        bridgeWeight += tw;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}