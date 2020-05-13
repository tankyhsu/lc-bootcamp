package com.lc.bootcamp.string;

/**
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