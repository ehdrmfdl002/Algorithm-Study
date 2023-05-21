public class Solution {
    public int solution(String s) {
        int answer = s.length(); 
        
        // 문자열을 1부터 s.length()/2까지의 단위로 자르며 압축된 문자열의 길이를 확인
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder compressed = new StringBuilder(); 
            String prev = s.substring(0, i); // 이전에 비교한 문자열 초기화
            int count = 1; // 연속된 문자열의 개수를 세는 변수
            
            // i부터 s.length()-i까지 i 단위로 문자열을 비교하여 압축
            for (int j = i; j <= s.length() - i; j += i) {
                String curr = s.substring(j, j + i); // 현재 비교할 문자열
                // 이전 문자열과 동일하면 count 증가
                if (prev.equals(curr)) {
                    count++;
                } else { // 이전 문자열과 다르면 압축된 문자열에 추가
                    if (count > 1) {
                        compressed.append(count); // 반복되는 문자열의 개수 추가
                    }
                    compressed.append(prev); // 반복되는 문자열 추가
                    prev = curr; // 이전 문자열을 현재 문자열로 업데이트
                    count = 1; // count 초기화
                }
            }
            
            // 마지막 문자열 처리
            if (count > 1) {
                compressed.append(count);
            }
            compressed.append(prev);
            
            // 남은 문자열 처리
            int remaining = s.length() % i;
            if (remaining > 0) {
                compressed.append(s.substring(s.length() - remaining));
            }
            
            // 압축된 문자열의 길이가 최소인 경우 업데이트
            answer = Math.min(answer, compressed.length());
        }
        
        return answer;
    }
}
