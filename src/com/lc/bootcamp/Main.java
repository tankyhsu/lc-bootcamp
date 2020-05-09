package com.lc.bootcamp;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] nums = {9,8,7,6,5,4,3,2,1,0};
        plusOne(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] plusOne(int[] digits) {
        long number = 0;
        for (int i = 0; i < digits.length; i++) {
            number += digits[i] * Math.pow(10, digits.length - i - 1);
        }
        number++;
        String numStr = String.valueOf(number);
        int[] plusOne = new int[numStr.length()];
        for (int i = plusOne.length - 1; i >= 0; i--) {
            plusOne[i] = (int) (number % 10);
            number /= 10;
        }
        return plusOne;
    }
}
