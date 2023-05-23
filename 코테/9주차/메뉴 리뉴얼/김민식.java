import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        for(int i = 0; i < orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        for(int size : course){
            for(String order : orders){
                comb("", order, size);
            }
            if(!map.isEmpty()){
                List<Integer> count = new ArrayList<>(map.values());
                int max = Collections.max(count);
                if(max > 1){
                    for(String key : map.keySet()){
                        if(map.get(key) == max) list.add(key);
                    }
                }
                map.clear();
            }
        }

        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public void comb(String order, String others, int cnt){
        if(cnt == 0){
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }
        for(int i = 0; i < others.length(); i++){
            comb(order + others.charAt(i), others.substring(i + 1), cnt - 1);
        }
    }
}