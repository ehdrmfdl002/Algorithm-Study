import java.util.*;

class Solution {
    static Map<String, List<String>> map = new HashMap<>();
    static List<String> list = new ArrayList<>();
    static boolean check = false;

    public String[] solution(String[][] tickets) {
        // 맵 생성
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }

        // map 정렬
        for (List<String> sortList : map.values()) {
            Collections.sort(sortList);
        }

        // 시작 지점인 "ICN"에서 출발하는 경로를 찾기
        dfs("ICN", 1, tickets.length, new ArrayList<>(Arrays.asList("ICN")));

        // 결과를 배열로 변환하여 반환
        return list.toArray(new String[0]);
    }

    private void dfs(String curr, int count, int targetCount, List<String> path) {
        if (count == targetCount + 1) {
            // 모든 항공권을 사용한 경우 결과를 업데이트
            list = new ArrayList<>(path);
            check = true;
            return;
        }

        if (map.containsKey(curr)) {
            // 현재 위치에서 이동할 수 있는 모든 목적지를 탐색
            for (int i = 0; i < map.get(curr).size(); i++) {
                String next = map.get(curr).get(i);
                if (!check) {
                    // 방문체크
                    map.get(curr).remove(i);
                    path.add(next);
                    dfs(next, count + 1, targetCount, path);
                    map.get(curr).add(i, next);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
