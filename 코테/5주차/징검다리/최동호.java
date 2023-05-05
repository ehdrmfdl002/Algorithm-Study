import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        //오름차순으로 정렬
        Arrays.sort(rocks);
        
        int answer = 0;
        int left = 0;
        int right = distance;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            // 이전 바위의 위치
            int past = 0; 
            // 제거한 바위의 수
            int cnt = 0; 
            
            for (int rock : rocks) {
                int num = rock - past;
                // num이 mid보다 작은 경우 cnt를 늘려 해당 바위를 제거
                if (num < mid) {
                    cnt++; 
                // 아닐 경우 cnt 유지 하고 바위 위치 유지
                } else {
                    past = rock; 
                }
            }
            
            // 마지막 바위와 도착위치 사이의 거리가 mid보다 작은 경우 cnt를 늘려 마지막 바위를 제거
            if (distance - past < mid) {
                cnt++;
            }
            // 제거한 바위의 수가 n 이하인 경우 mid 값을 충분히 유지가능 > mid 값 중 최댓값 구하기
            if (cnt <= n) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            // 제거한 바위의 수가 n 초과인 경우, mid 값을 유지할 수 없음 > mid 값을 줄이기
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
