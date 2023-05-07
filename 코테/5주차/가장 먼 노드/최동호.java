import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        int max = 0;
        int answer = 0;
        
        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // BFS 탐색
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int adj : graph.get(node)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    dist[adj] = dist[node] + 1;
                    max = Math.max(max, dist[adj]);
                    queue.add(adj);
                }
            }
        }
        
        // 가장 먼 거리를 가진 노드 개수 세기
        for (int i = 1; i <= n; i++) {
            if (dist[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}
