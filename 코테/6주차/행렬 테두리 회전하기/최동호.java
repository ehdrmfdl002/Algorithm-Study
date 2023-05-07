import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        int[] answer = new int[queries.length];

        // 2차원 배열 초기화
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = i * columns + j + 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            // 회전 범위 내의 테두리 숫자들 저장
            List<Integer> nums = new ArrayList<>();
            for (int j = y1; j < y2; j++) {
                nums.add(map[x1][j]);
            }
            for (int j = x1; j < x2; j++) {
                nums.add(map[j][y2]);
            }
            for (int j = y2; j > y1; j--) {
                nums.add(map[x2][j]);
            }
            for (int j = x2; j > x1; j--) {
                nums.add(map[j][y1]);
            }

            // 회전 범위 내의 테두리 숫자들 회전
            int temp = nums.remove(nums.size() - 1);
            nums.add(0, temp);
            int minVal = temp;

            for (int j = y1; j < y2; j++) {
                int num = nums.remove(0);
                map[x1][j] = num;
                minVal = Math.min(minVal, num);
            }
            for (int j = x1; j < x2; j++) {
                int num = nums.remove(0);
                map[j][y2] = num;
                minVal = Math.min(minVal, num);
            }
            for (int j = y2; j > y1; j--) {
                int num = nums.remove(0);
                map[x2][j] = num;
                minVal = Math.min(minVal, num);
            }
            for (int j = x2; j > x1; j--) {
                int num = nums.remove(0);
                map[j][y1] = num;
                minVal = Math.min(minVal, num);
            }

            answer[i] = minVal; // 회전 후 최소값 저장
        }

        return answer;
    }
}