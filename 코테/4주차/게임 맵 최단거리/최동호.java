import java.util.*;

class Solution {
    static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1});
        maps[0][0] = 0;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2];
            
            if (row == n - 1 && col == m - 1) 
                return dist;
            
            for(int i = 0; i < 4; i++){
                int nextRow = row + dx[i];
                int nextCol = col + dy[i];
                
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                    continue;
                }
                
                if (maps[nextRow][nextCol] == 0) {
                    continue;
                }
                
                q.offer(new int[]{nextRow, nextCol, dist+1});
                maps[nextRow][nextCol] = 0;
            }
            
        }
        
        return -1;
    }
}
