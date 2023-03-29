import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int max = Integer.MIN_VALUE;

        int[] supoja1 = {1,2,3,4,5};
        int[] supoja2 = {2,1,2,3,2,4,2,5};
        int[] supoja3 = {3,3,1,1,2,2,4,4,5,5};
        
        int list[] = new int[3];
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<answers.length;i++){
            if(answers[i] == supoja1[i%5]) list[0]++;
            if(answers[i] == supoja2[i%8]) list[1]++;
            if(answers[i] == supoja3[i%10]) list[2]++;
        }
        
        max = Math.max(Math.max(list[0],list[1]),list[2]);
        for(int i=0;i<list.length;i++){
            if(max == list[i]) ans.add(i+1);
        }
        
        return ans.stream().mapToInt(i->i).toArray();
    }
}
