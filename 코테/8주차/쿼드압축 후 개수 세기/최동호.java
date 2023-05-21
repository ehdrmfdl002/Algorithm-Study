class Solution {
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }

    public void compress(int[][] arr, int row, int col, int size) {
        if (check(arr, row, col, size)) {
            // 모든 수가 같은 값일 경우 압축
            answer[arr[row][col]]++;
            return;
        }

        int newSize = size / 2;
        // 4개의 균일한 정사각형 영역으로 나누어 압축 시도
        compress(arr, row, col, newSize); // 좌상단 영역
        compress(arr, row, col + newSize, newSize); // 우상단 영역
        compress(arr, row + newSize, col, newSize); // 좌하단 영역
        compress(arr, row + newSize, col + newSize, newSize); // 우하단 영역
    }

    public boolean check(int[][] arr, int row, int col, int size) {
        int value = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}