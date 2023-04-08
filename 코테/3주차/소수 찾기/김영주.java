import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] visited;
    public int solution(String numbers) {
        int answer=0;
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for(int i=0;i<numbers.length();i++){
            arr[i] = numbers.charAt(i);
        }
        
        dfs("",0);
        
        answer = set.size();
        return answer;
    }
    
    private void dfs(String s, int idx){
        
        int num=0;
        if(s != ""){
            num = Integer.parseInt(s);
            if(isPrime(num)) set.add(num);
        }
        
        for(int i=0;i<arr.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(s+arr[i],idx+1);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int num){
        if(num == 0 || num == 1) return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
    
}
