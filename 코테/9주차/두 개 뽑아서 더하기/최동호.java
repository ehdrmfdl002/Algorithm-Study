import java.util.*;

public class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }
        
        List<Integer> resultList = new ArrayList<>(set);
        int[] answer = new int[resultList.size()];
        
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}
