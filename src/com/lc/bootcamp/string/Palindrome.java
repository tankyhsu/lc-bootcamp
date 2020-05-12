package com.lc.bootcamp.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 *
 * @author tianqi.xu
 * 2020/5/12
 */
public class Palindrome {
    public static boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            // 判断空格
            if (!isValid(s.charAt(head))) {
                head++;
                continue;
            }
            if (!isValid(s.charAt(tail))) {
                tail--;
                continue;
            }
            if (!equal(s.charAt(head), s.charAt(tail))) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }

    public static boolean isValid(char a) {
        return (a >= 48 && a <= 57) || (a >= 65 && a <= 90) || (a >= 97 && a <= 122);
    }

    public static boolean equal(char a, char b) {
        if (a == b) {
            return true;
        }
        return a >= 65 && b >= 65 && Math.abs(a - b) == 32;
    }
}
