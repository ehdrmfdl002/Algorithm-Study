import java.util.*;

class Solution {
    // 사용자 아이디 목록을 저장하는 리스트
    private static List<String> userIdList;
    // 제재 아이디 목록을 저장하는 배열
    private static String[] bannedIds;
    // 사용자 아이디의 사용 여부를 저장하는 배열
    private static boolean[] check;
    // 결과를 저장하는 set
    private static Set<List<String>> resultSet;

    public static int solution(String[] user_id, String[] banned_id) {
        userIdList = new ArrayList<>(); 
        
        for (String id : user_id)
            userIdList.add(id);

        bannedIds = banned_id; // 제재 아이디 목록을 저장
        check = new boolean[userIdList.size()]; // 아이디 사용 여부 배열을 초기화
        resultSet = new HashSet<>(); // 결과를 저장할 집합(Set)을 초기화

        check(0);

        return resultSet.size(); // 경우의 수 반환
    }

    // user와 banned가 매치되는지 확인하는 함수
    private static boolean isMatch(String user, String banned) {
        if (user.length() != banned.length())
            return false;
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*')
                continue;
            if (user.charAt(i) != banned.charAt(i))
                return false;
        }
        return true;
    }
    
    private static void check(int index) {
        // 모든 제재 아이디를 확인한 경우
        if (index == bannedIds.length) {
            // 선택된 아이디를 저장할 리스트
            List<String> selectedIds = new ArrayList<>();
            // 사용된 아이디만 선택해서 리스트에 추가
            for (int i = 0; i < check.length; i++) {
                if (check[i])
                    selectedIds.add(userIdList.get(i));
            }
            // 결과 집합에 추가
            resultSet.add(selectedIds);
            return;
        }
        // 현재 제재 아이디와 매치되는 사용자 아이디를 찾음
        for (int i = 0; i < userIdList.size(); i++) {
            // 이미 사용된 아이디는 건너뜀
            if (check[i])
                continue;
            // 매치되는 경우
            if (isMatch(userIdList.get(i), bannedIds[index])) {
                check[i] = true; // 아이디 사용 여부를 표시
                check(index + 1); // 다음 제재 아이디로 넘어감
                check[i] = false; //아이디 사용 여부를 초기화
            }
        }
    }
}
