import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 사람들을 무게 순으로 정렬
        int answer = 0;
        int left = 0, right = people.length - 1; // 가장 가벼운 사람과 가장 무거운 사람의 인덱스
        while (left <= right) {
            if (people[right] + people[left] <= limit) { // 가장 무거운 사람과 가장 가벼운 사람이 같이 탈 수 있는 경우
                left++; // 다음으로 가벼운 사람과 비교하기 위해 left를 1 증가시킴
            }
            right--; // 가장 무거운 사람은 항상 타기 때문에 right를 1 감소시킴
            answer++; // 구명보트 개수 1 증가
        }
        return answer;
    }
}
