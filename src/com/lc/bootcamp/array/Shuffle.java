package com.lc.bootcamp.array;

import java.util.Arrays;
import java.util.Random;

/**
 * 打乱一个没有重复元素的数组。
 * <p>
 * <p>
 * 示例:
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 * <p>
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 * <p>
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 * @author tianqi.xu
 * 2020/6/19
 */
public class Shuffle {
    private int[] origin;

    public Shuffle(int[] nums) {
        origin = Arrays.copyOf(nums, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Random random = new Random();
        int[] result = new int[origin.length];
        for (int i = 1; i <= origin.length; i++) {
            int j = random.nextInt(origin.length);
            while (result[j] != 0) {
                j = random.nextInt(origin.length);
            }
            result[j] = i;
        }

        for (int i = 0; i < origin.length; i++) {
            result[i] = origin[result[i] - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Shuffle shuffle = new Shuffle(nums);
        System.out.println(Arrays.toString(shuffle.shuffle()));
    }

}
