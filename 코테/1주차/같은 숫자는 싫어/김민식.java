import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new LinkedList<>();
        dq.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(dq.getLast() != arr[i]) dq.addLast(arr[i]);
        }

        return dq.stream().mapToInt(i -> i).toArray();
    }
}