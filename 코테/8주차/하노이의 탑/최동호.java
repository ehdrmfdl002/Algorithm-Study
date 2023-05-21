import java.util.ArrayList;

class Solution {
    public ArrayList<int[]> solution(int n) {
        ArrayList<int[]> answer = new ArrayList<>();
        // 원판을 옮기는 메서드 호출
        moveDisks(n, 1, 2, 3, answer);
        return answer;
    }
    
    private void moveDisks(int n, int start, int tmp, int end, ArrayList<int[]> answer) {
        if (n == 1) {
            // 원판을 옮기는 과정을 배열로 저장하여 answer 리스트에 추가
            answer.add(new int[]{start, end});
        } else {
            // n-1개의 원판을 aux 기둥으로 옮김 (보조 기둥 사용)
            moveDisks(n - 1, start, end, tmp, answer);
            // 가장 큰 원판을 목표 기둥으로 옮김
            answer.add(new int[]{start, end});
            // aux 기둥에 있는 n-1개의 원판을 목표 기둥으로 옮김 (보조 기둥 사용)
            moveDisks(n - 1, tmp, start, end, answer);
        }
    }
}
