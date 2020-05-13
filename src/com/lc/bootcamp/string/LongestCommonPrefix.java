package com.lc.bootcamp.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author tianqi.xu
 * 2020/5/13
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int i = 0;
        StringBuilder prefix = new StringBuilder();
        if (strs[0].length() < 1) {
            return prefix.toString();
        }
        while (i < strs[0].length()) {
            char value = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i + 1 || value != strs[j].charAt(i)) {
                    return prefix.toString();
                }
            }
            prefix.append(value);
            i++;
        }
        return prefix.toString();
    }
}