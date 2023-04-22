import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, visited, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int start, boolean[] visited, int[][] computers) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < computers[x].length; i++) {
                if (computers[x][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    
}
