package com.lc.bootcamp;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * <p>
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * Related Topics 位运算 数组 数学
 *
 * @author tianqi.xu
 * 2020/6/24
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        int sum2 = (len) * (len + 1) / 2;
        return sum2 - sum;
    }

    /**
     * 位运算解法
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
