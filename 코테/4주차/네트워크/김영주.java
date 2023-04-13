class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer=0;
        
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            dfs(i,n,computers);
            answer++;
        }
        
        return answer;
    }
    
    public void dfs(int idx, int n, int[][] computers){
        visited[idx] = true;
        
        for(int i=0;i<n;i++){
            if(!visited[i] && computers[idx][i] == 1){
                dfs(i,n,computers);
            }
        }
    }
}
