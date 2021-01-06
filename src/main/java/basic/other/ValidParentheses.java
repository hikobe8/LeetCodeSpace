package basic.other;

import java.util.*;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("{[()]}()"));
        System.out.println(isValid("{[()][]}()}"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()"));
//        System.out.println((int)'(');
//        System.out.println((int)'[');
//        System.out.println((int)'{');
//        System.out.println((int)')');
//        System.out.println((int)']');
//        System.out.println((int)'}');
    }

    public static boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        if (s.length() % 2 != 0)
            return false;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == 41 || charAt == 93 || charAt == 125) {
                if (stack.isEmpty() || !isMatch(charAt, stack.peek())){
                    return false;
                }
                stack.pop();
            } else {
                stack.push(charAt);
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatch(char c1, char c2){
        switch (c1) {
            case 41:
                return c2 == 40;
            case 93:
                return c2 == 91;
            case 125:
                return c2 == 123;
        }
        return false;
    }

}
