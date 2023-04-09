import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private ArrayList<Integer>[] graph;
    private boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int u = wire[0], v = wire[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int[] wire : wires) {
            int u = wire[0], v = wire[1];

            // 끊어진 전선을 기준으로 각각의 그래프 크기 계산
            graph[u].remove((Integer) v);
            graph[v].remove((Integer) u);
            visited = new boolean[n + 1];
            int cnt1 = dfs(u);
            int cnt2 = n - cnt1;
            answer = Math.min(answer, Math.abs(cnt1 - cnt2));

            // 다시 연결
            graph[u].add(v);
            graph[v].add(u);
        }

        return answer;
    }
    
    private int dfs(int start) {
        visited[start] = true;

        int cnt = 1;
        for (int next : graph[start]) {
            if (!visited[next]) {
                cnt += dfs(next);
            }
        }

        return cnt;
    }
}