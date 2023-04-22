import java.util.*;

class Solution {
    public boolean[][] visited;
    public int[] dx = {1, -1, 0, 0};
    public int[] dy = {0, 0, 1, -1};
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        return bfs(maps);
    }
    
    public int bfs(int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        int cnt = 1;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] num = q.poll();
                for(int i = 0; i < 4; i++){
                    int nx = num[0] + dx[i];
                    int ny = num[1] + dy[i];
                    if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) continue;
                    if(visited[nx][ny] || maps[nx][ny] != 1) continue;
                    if(nx == maps.length - 1 && ny == maps[0].length - 1) return cnt + 1;
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
            cnt++;
        }
        return -1;
    }
    
}