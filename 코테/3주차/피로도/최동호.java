class Solution {
    private int max; // 탐험 가능한 최대 던전 수
    private boolean[] visited; // 던전 탐험 여부를 저장하는 배열

    public int solution(int k, int[][] dungeons) {
        max = 0;
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return max;
    }

    private void dfs(int k, int[][] dungeons, int count) {
        if (count > max) { // 탐험 가능한 최대 던전 수 갱신
            max = count;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) { // 던전을 탐험할 수 있는 경우
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, count + 1); // 다음 던전 탐험을 위해 재귀 호출
                visited[i] = false;
            }
        }
    }
}
