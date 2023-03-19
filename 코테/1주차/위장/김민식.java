import java.util.*;

// 종류만 key값으로 넣어 갯수 구한 후 부분집합으로 구하기 -> 테케 1번만 시간초과
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }

        for(String key : map.keySet()) answer *= map.get(key);
        return answer - 1;
    }
}