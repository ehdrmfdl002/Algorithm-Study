import java.util.*;
import java.io.*;

class Solution {
    static class pos{
        int x;
        int y;
        int cnt;
        
        public pos(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int min;
    static boolean flag;
    static Queue<pos> q;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) {
        q = new LinkedList<>();
        visited = new boolean[maps.length][maps[0].length];
        
        bfs(0,0,maps);
        return min;
    }
    
    public void bfs(int i, int j,int[][] maps){
        
        q.offer(new pos(i,j,0));
        visited[i][j] = true;
        
        while(!q.isEmpty()){
            pos p = q.poll();
            
            if(p.x == maps.length-1 && p.y == maps[0].length-1){
                min = p.cnt+1;
                flag = true;
                return;
            }
            
            for(int d=0;d<4;d++){
                int px = p.x+dx[d];
                int py = p.y+dy[d];
                
                if(px<0 || px>=maps.length || py<0 || py>=maps[0].length) continue;
                if(visited[px][py] || maps[px][py] == 0) continue;
                
                visited[px][py] = true;
                q.offer(new pos(px,py,p.cnt+1));
            }
        }
        if(!flag) min = -1;
    }
}
