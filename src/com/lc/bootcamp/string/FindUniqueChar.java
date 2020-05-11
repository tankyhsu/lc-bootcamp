package com.lc.bootcamp.string;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * @author tianqi.xu
 * 2020/5/11
 */
public class FindUniqueChar {
    public static int firstUniqChar(String s) {
        int[] helper = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (helper[c - 97] == 0) {
                // 第一次出现
                helper[c - 97] = i + 1;
            } else {
                helper[c - 97] = -1;
            }
        }
        int min = 0;
        for (int i : helper) {
            if ((min > i || min == 0) && i > 0) {
                min = i;
            }
        }
        return min - 1;
    }
}
