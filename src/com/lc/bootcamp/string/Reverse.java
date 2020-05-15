package com.lc.bootcamp.string;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author tianqi.xu
 * 2020/5/15
 */
public class Reverse {
    public static int reverse(int x) {
        int sign = Integer.compare(x, 0);
        long val = x;
        String str = String.valueOf(Math.abs(val));
        char[] s = str.toCharArray();
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            s[i] += s[len - i - 1]; // a+b
            s[len - i - 1] = (char) (s[i] - s[len - i - 1]); // a
            s[i] = (char) (s[i] - s[len - i - 1]); // b
        }
        str = new String(s);
        val = Long.parseLong(str);
        if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) (val * sign);
    }
}
