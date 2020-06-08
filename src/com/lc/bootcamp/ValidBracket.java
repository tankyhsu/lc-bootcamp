package com.lc.bootcamp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 * Related Topics 栈 字符串
 *
 * @author tianqi.xu
 * 2020/6/8
 */
public class ValidBracket {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (brackets.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if ((brackets.get(stack.peek()) == c)) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    static Map<Character, Character> brackets = new HashMap<>();

    static {
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('[', ']');
    }

    public static void main(String[] args) {
        isValid(")}{({))[{{[}");
    }
}
