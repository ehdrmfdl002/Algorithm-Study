import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // 최소, 최대 시간
        long answer = Long.MAX_VALUE;
        long left = 1;
        long right = (long)n * (long)Arrays.stream(times).max().getAsInt();
        
        
        while (left <= right) {
            // 중간값 계산
            long mid = (left + right) / 2;
            // 각 심사대에서 처리할 수 있는 인원 수 계산
            long count = 0;
            for (int time : times) {
                count += mid / time;
            }
            
            // 처리할 수 있는 인원 수가 n 이상일 경우 모든 사람이 mid 시간 동안 심사 가능
            // 시간 감소
            if (count >= n) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            // 처리할 수 있는 인원수가 n 미만일 경우 모든 사람이 mid 시간 동안 심사 불가
            // 시간 증가
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}
