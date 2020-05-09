package com.lc.bootcamp;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @author tianqi.xu
 * 2020/5/9
 */
public class ContainDuplicate {
    /**
     * O(2n)解法，空间代价很大
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if (Math.abs(num) > max) {
                max = Math.abs(num);
            }
        }
        int[] arr = new int[max + 1];
        for (int num : nums) {
            int sign = (num < 0) ? 2 : 1;
            if (arr[Math.abs(num)] > 0) {
                if ((sign ^ arr[Math.abs(num)]) != 3)
                    arr[Math.abs(num)] += sign;
                else
                    return true;
            } else {
                arr[Math.abs(num)] += sign;
            }
        }
        return false;
    }

    /**
     * 官方解法
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
