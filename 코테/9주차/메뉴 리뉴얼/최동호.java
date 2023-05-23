import java.util.*;

class Solution {
    Map<String, Integer> courseMap; // 코스요리 메뉴 조합과 주문 횟수를 저장하는 맵

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            courseMap = new HashMap<>();
            for (String order : orders) {
                char[] menuArr = order.toCharArray();
                Arrays.sort(menuArr); // 알파벳 오름차순 정렬
                combination(menuArr, new StringBuilder(), 0, course[i]);
            }

            List<String> maxCourses = findMaxCourses();
            answerList.addAll(maxCourses);
        }

        // 결과 정렬
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        answerList.toArray(answer);
        return answer;
    }

    private void combination(char[] menuArr, StringBuilder sb, int start, int courseLen) {
        if (courseLen == 0) {
            courseMap.put(sb.toString(), courseMap.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = start; i < menuArr.length; i++) {
            sb.append(menuArr[i]);
            combination(menuArr, sb, i + 1, courseLen - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private List<String> findMaxCourses() {
        List<String> maxCourses = new ArrayList<>();
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : courseMap.entrySet()) {
            int count = entry.getValue();
            if (count >= 2 && count >= maxCount) {
                if (count > maxCount) {
                    maxCount = count;
                    maxCourses.clear();
                }
                maxCourses.add(entry.getKey());
            }
        }

        return maxCourses;
    }
}
