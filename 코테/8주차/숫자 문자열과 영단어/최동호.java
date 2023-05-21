import java.util.*;

class Solution {
    public int solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        StringBuilder number = new StringBuilder();
        StringBuilder result = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            // 숫자인지 판단
            if (Character.isDigit(c)) {
                result.append(c);
            } else {
                number.append(c);
                if (map.containsKey(number.toString())) {
                    result.append(map.get(number.toString()));
                    number.setLength(0);
                }
            }
        }
        
        return Integer.parseInt(result.toString());
    }
}
