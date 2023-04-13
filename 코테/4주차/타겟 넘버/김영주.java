class Solution {
    static int tot;
    static boolean[] visited;
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        
        dfs(0,0,numbers,target);
        return tot;
    }
    
    public void dfs(int idx, int sum, int[] numbers, int target){
        
        if(idx == numbers.length){
            if(sum == target) tot++;
            return;
        }
        
        if(!visited[idx]){
            visited[idx] = true;
            dfs(idx+1,sum+numbers[idx],numbers,target);
            dfs(idx+1,sum-numbers[idx],numbers,target);
            visited[idx] = false;
        }
    }
}
