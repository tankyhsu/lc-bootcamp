package com.lc.bootcamp.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author tianqi.xu
 * 2020/5/9
 */
public class RemoveZeros {
    public void moveZeroes(int[] nums) {
        int count = 0; // 非0数字个数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
