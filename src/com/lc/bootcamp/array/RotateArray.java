package com.lc.bootcamp.array;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * @author tianqi.xu
 * 2020/5/9
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            // k是数组长度的整数倍，不需要移动
            return;
        }

        // 最大公约数
        int factor = maxNumber(k, nums.length);
        for (int j = 0; j < factor; j++) {
            singleRound(nums, k, j, nums.length / factor);
        }

    }

    public void singleRound(int nums[], int k, int tempIndex, int len) {
        int temp = nums[tempIndex];
        for (int i = 1; i <= len; i++) {
            if (i * k + tempIndex < nums.length) {
                temp = temp + nums[i * k + tempIndex];
                nums[i * k + tempIndex] = temp - nums[i * k + tempIndex]; // temp
                temp = temp - nums[i * k + tempIndex]; // nums[i*k]
            } else {
                temp = temp + nums[i * k % nums.length + tempIndex];
                nums[i * k % nums.length + tempIndex] = temp - nums[i * k % nums.length + tempIndex]; // temp
                temp = temp - nums[i * k % nums.length + tempIndex]; // nums[i*k]
            }
        }
    }

    /**
     * 辗转相除法
     *
     * @param m
     * @param n
     * @return
     */
    int maxNumber(int m, int n) {
        int temp;
        if (n > m) {
            temp = n;
            n = m;
            m = temp;
        }
        if (m % n == 0) {
            return n;
        }
        return maxNumber(n, m % n);
    }
}
