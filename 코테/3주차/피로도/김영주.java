import java.util.*;

class Solution {
    static boolean[] visited;
    static int max;
    public int solution(int k, int[][] dungeons) {
        
        max = Integer.MIN_VALUE;
        visited = new boolean[dungeons.length];
        
        dfs(k,0,dungeons);
        
        return max;
    }
    
    public void dfs(int k,int depth, int [][] dungeons){
        
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && k>=dungeons[i][0]){
                
                visited[i] = true;
                dfs(k-dungeons[i][1],depth+1,dungeons);
                visited[i] = false;
            }
        }
        max= Math.max(max,depth);
    }
}
