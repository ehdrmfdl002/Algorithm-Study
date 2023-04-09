import java.util.*;

class Solution {
    private static Set<Integer> primeNumbers = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        List<Character> list = new ArrayList<>();
        
        for(int i = 0; i < numbers.length(); i++) {
            list.add(numbers.charAt(i));
        }
        
         for(int i = 1; i <= list.size(); i++) {
            permutation(list, new boolean[list.size()], new StringBuilder(), i);
        }
        
        answer = primeNumbers.size();
        
        return answer;
    }
    
    private void permutation(List<Character> list, boolean[] visited, StringBuilder sb, int length) {
        if(sb.length() == length) {
            int num = Integer.parseInt(sb.toString());
            if(isPrime(num)) {
                primeNumbers.add(num);
            }
            
            return;
        }
        
        for(int i = 0; i < list.size(); i++) {
            if(visited[i]) 
                continue;
            
            visited[i] = true;
            sb.append(list.get(i));
            permutation(list, visited, sb, length);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
        
    }
    
    
    private boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}