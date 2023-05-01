import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int[] dist;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        initGraph(n, edge);
        bfs();
        
        for(int num : dist){
            if(num == max) answer++;
        }
        return answer;
    }
    
    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0;
        visited[1] = true;
        
        while(!q.isEmpty()){
            int k = q.poll();
            for(Integer num : graph[k]){
                if(!visited[num]){
                    q.add(num);
                    visited[num] = true;
                    dist[num] = dist[k] + 1;
                    max = Math.max(max, dist[num]);
                }
            }
        }
    }
    
    public static void initGraph(int n, int[][] edge){
        graph = new ArrayList[n + 1];
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edge.length; i++){
            int x = edge[i][0];
            int y = edge[i][1];
            
            graph[x].add(y);
            graph[y].add(x);
        }
    }
}