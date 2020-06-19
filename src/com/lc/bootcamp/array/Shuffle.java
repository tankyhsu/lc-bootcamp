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

    /**
     * official solution
     * <p>
     * 方法二： Fisher-Yates 洗牌算法 【通过】
     * 思路
     * <p>
     * 我们可以用一个简单的技巧来降低之前算法的时间复杂度和空间复杂度，那就是让数组中的元素互相交换，这样就可以避免掉每次迭代中用于修改列表的时间了。
     * <p>
     * 算法
     * <p>
     * Fisher-Yates 洗牌算法跟暴力算法很像。在每次迭代中，生成一个范围在当前下标到数组末尾元素下标之间的随机整数。接下来，将当前元素和随机选出的下标所指的元素互相交换
     * 这一步模拟了每次从 “帽子” 里面摸一个元素的过程，其中选取下标范围的依据在于每个被摸出的元素都不可能再被摸出来了。此外还有一个需要注意的细节，当前元素是可以和它本身互相交换的 - 否则生成最后的排列组合的概率就不对了。
     * <p>
     */
    private int[] array;
    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] shuffle2() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Shuffle shuffle = new Shuffle(nums);
        System.out.println(Arrays.toString(shuffle.shuffle()));
    }

}
