import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            char word = number.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() < word) {
                stack.pop();
                k--;
            }
            stack.push(word);
        }
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
