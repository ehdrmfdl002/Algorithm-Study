package programmers;
import java.util.Stack;
public class pro_올바른괄호 {
    class Solution {
        boolean solution(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }

            return stack.isEmpty();
        }
    }
}
