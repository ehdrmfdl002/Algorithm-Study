import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<commands.length;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=commands[i][0]-1;j<commands[i][1];j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            ans.add(list.get(commands[i][2]-1));
        }
        return ans.stream().mapToInt(i->i).toArray();
    }
}
