import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> list;
    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        dfs("ICN","ICN",0,tickets);
        
        Collections.sort(list);
        return list.get(0).split(" ");
    }
    
    public void dfs(String start, String path, int cnt, String[][] tickets){
        
        if(cnt == tickets.length){
            list.add(path);
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && start.equals(tickets[i][0])){
                visited[i] = true;
                dfs(tickets[i][1],path+" "+tickets[i][1],cnt+1,tickets);
                visited[i] = false;
            }
        }
    }
}
