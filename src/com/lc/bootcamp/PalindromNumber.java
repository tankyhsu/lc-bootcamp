package com.lc.bootcamp;

/**
 * @author tianqi.xu
 * 2020/6/10
 */
public class PalindromNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = x % 10;
        int z = x / 10;
        while (z > 0) {
            y = y * 10 + z % 10;
            z /= 10;
        }
        return x == y;
    }

    public static void main(String[] args) {
        isPalindrome(121);
    }
}
