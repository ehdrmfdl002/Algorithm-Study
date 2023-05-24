import java.util.*;
import java.io.*;

class Solution {
    static int cnt;
    
    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> combinations = new ArrayList<>();
        List<String> list = new ArrayList<>(Arrays.asList(user_id));
        
        dfs(list, banned_id, new ArrayList<>(), combinations, 0);
        
        cnt = combinations.size(); // 경우의 수 개수
        
        return cnt;
    }
    
    static void dfs(List<String> list, String[] banned_id, List<String> combination, List<List<String>> combinations, int idx) {
        
        if (combination.size() == banned_id.length) {
            List<String> newCombination = new ArrayList<>(combination);
            Collections.sort(newCombination); // 중복 제거를 위해 정렬
            if (!combinations.contains(newCombination)) {
                combinations.add(newCombination);
            }
            return;
        } 
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == banned_id[idx].length()) {
                String temp = list.get(i);
                boolean flag = false;
                for (int j = 0; j < temp.length(); j++) {
                    if (temp.charAt(j) == banned_id[idx].charAt(j) || banned_id[idx].charAt(j) == '*') {
                        continue;
                    } else {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    combination.add(temp);
                    List<String> modifiedList = new ArrayList<>(list);
                    modifiedList.remove(temp);
                    dfs(modifiedList, banned_id, combination, combinations, idx + 1);
                    combination.remove(temp);
                }
            }
        }
    }
}
