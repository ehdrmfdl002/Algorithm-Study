import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        solution(new String[] {"a"}, 2);
    }
    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            if (o1.charAt(n) == o2.charAt(n)) return o1.compareTo(o2);
            else return o1.charAt(n) - o2.charAt(n);
        });
       return strings;
    }
}
