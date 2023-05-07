class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int minMove = len - 1; // 첫 번째 위치에서 마지막 문자까지 이동하는 경우를 최대값으로 설정

        for (int i = 0; i < len; i++) {
            // 위 아래로 조작하는 횟수 계산
            char word = name.charAt(i);
            answer += Math.min(word - 'A', 'Z' - word + 1);

            // A가 아닌 문자를 만날 때까지 좌우로 이동하는 횟수 계산
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            int move = i + len - next + Math.min(i, len - next);
            minMove = Math.min(minMove, move);
        }

        answer += minMove;
        return answer;
    }
}

