public class Solution {
    public int solution(int n) {
        String reversed = reverse(n); // 3진법을 앞뒤로 뒤집은 문자열을 구합니다.
        int answer = convert(reversed); // 뒤집힌 3진법을 10진법으로 변환합니다.
        return answer;
    }

    // 주어진 자연수를 3진법으로 변환하는 메소드
    private String reverse(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 3); // 3으로 나눈 나머지를 문자열에 추가
            n /= 3; // 3으로 나눈 몫을 다음 숫자로 설정
        }
        return sb.toString();
    }

    // 주어진 문자열을 10진법으로 변환하는 메소드
    private int convert(String reversed) {
        int decimal = 0;
        int power = 0;
        for (int i = reversed.length() - 1; i >= 0; i--) {
            int digit = reversed.charAt(i) - '0'; // 문자를 정수로 변환
            decimal += digit * Math.pow(3, power); // 3의 제곱수를 곱하여 10진법으로 변환
            power++;
        }
        return decimal;
    }
}
