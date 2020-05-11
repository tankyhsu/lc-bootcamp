package com.lc.bootcamp.string;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author tianqi.xu
 * 2020/5/11
 */
public class Anagram {
    public static boolean anagram(String s, String t) {
        HashMap<Character, Integer> result = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (result.containsKey(c)) {
                result.put(c, result.get(c) + 1);
            } else {
                result.put(c, 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (result.containsKey(c)) {
                result.put(c, result.get(c) - 1);
            } else {
                return false;
            }
        }
        AtomicBoolean isAnagram = new AtomicBoolean(true);
        result.forEach((character, integer) -> {
            if (integer != 0) {
                isAnagram.set(false);
            }
        });
        return isAnagram.get();
    }
}
