import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
       int ans[] = new int[2];
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(String s: operations){
            String[] arr = s.split(" ");
            int num = Integer.parseInt(arr[1]);
            if(arr[0].equals("I")) {
                maxQ.add(num);
                minQ.add(num);
                list.add(num);
            }else{
                if(num == -1) maxQ.remove(minQ.poll());
                else minQ.remove(maxQ.poll());
            }
        }
        ans[0] = maxQ.isEmpty() ? 0: maxQ.peek();
        ans[1] = minQ.isEmpty() ? 0: minQ.peek();
        return ans;
    }
}
