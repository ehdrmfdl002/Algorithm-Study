import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] array = new String[numbers.length];
        
        // 문자열로 변환
        for(int i = 0; i < numbers.length; i++) {
            array[i] = String.valueOf(numbers[i]);
        }
        
        // 문자열을 비교하여 정렬
        Arrays.sort(array, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        // 가장 큰 수를 구함
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < array.length; i++){
            String str = array[i];
            sb.append(str);
        }
        
        // 첫 번째 요소가 0이면 0이 가장 큰 수이므로 "0"을 반환
        if(sb.charAt(0) == '0'){
            return "0";
        }
        
        return sb.toString();
    }
}
