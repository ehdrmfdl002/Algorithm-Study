import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            
            // array 배열을 복사하여 일부분씩 자르기
            // copyOfRange(복사할 배열, 시작위치, 배열크기)
            int[] tmp = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            
            // 일부분씩 자른 배열을 정렬하기
            Arrays.sort(tmp);
            
            // K번째 작은 수 찾기
            answer[i] = tmp[command[2] - 1];
        }
        
        return answer;
    }
}
