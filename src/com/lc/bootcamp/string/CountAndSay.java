package com.lc.bootcamp.string;

/**
 * @author tianqi.xu
 * 2020/5/13
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        String value = "1";
        for (int i = 0; i < n-1; i++) {
            value = describe(value);
        }
        return value;
    }

    public static String describe(String num) {
        char item = num.charAt(0);
        StringBuilder desc = new StringBuilder();
        int count = 0;
        for (char c : num.toCharArray()) {
            if (c == item) {
                count++;
            } else {
                desc.append(count).append(item);
                item = c;
                count = 1;
            }
        }
        desc.append(count).append(item);
        return desc.toString();
    }
}
