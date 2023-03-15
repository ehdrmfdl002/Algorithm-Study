import java.util.HashMap;

class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                String num = phone_book[i].substring(0, j);
                if (map.containsKey(num)) {
                    return false;
                }
            }
        }
        return true;
    }
}