import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean check = false;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                check = true;
                break;
            }
        }
        if (!check) {
            return 0;
        }
        
        // BFS 알고리즘을 이용한 탐색
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.offer(begin);
        visited.add(begin);
        int num = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                String current = q.poll();
                if (current.equals(target)) {
                    return num;
                }
                
                // 한 글자씩만 바꾸면서 words 집합에 있는 단어들과 비교               
                for (int j = 0; j < words.length; j++) {
                    if (!visited.contains(words[j]) && isCheck(current, words[j])) {
                        visited.add(words[j]);
                        q.offer(words[j]);
                    }
                } 
            }
            
            num++;
        }
        return 0; // 변환 불가능한 경우
    }
    
    // 두 단어가 한 글자만 다른지 확인하는 함수
    private boolean isCheck(String word1, String word2) {
        int num = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                num++;
            }
            
            if (num > 1) {
                return false;
            }
        }
        return num == 1;
    }
}
