import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if(!Arrays.asList(words).contains(target)) return answer;
        Queue<String> q = new LinkedList<>();
        boolean[][] visited = new boolean[words.length][words.length];
        HashMap<String, Integer> dir = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            dir.put(words[i], i);
        }
        q.add(begin);
        
        while(!q.isEmpty()){
            answer++;
            int size = q.size();
            while(size-- > 0){
                String str = q.poll();
                String[] strToArr = str.split("");
                outer:for(int i = 0; i < words.length; i++){
                    // 같은 값이면 패스
                    if(words[i].equals(str)) continue;
                    // 해당 단어가 이전에 바꿨으면 패스
                    if(visited[dir.get(words[i])][i]) continue;
                    String[] wordToArr = words[i].split("");
                    int cnt = 0;
                    for(int j = 0; j < wordToArr.length; j++){
                        if(!wordToArr[j].equals(strToArr[j])) cnt++;
                        if(cnt > 1) continue outer;
                    }
                    if(words[i].equals(target)) return answer;
                    q.add(words[i]);
                    visited[dir.get(words[i])][i] = true;
                }
            }
            
        }
        return answer;
    }
}