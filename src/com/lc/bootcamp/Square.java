package com.lc.bootcamp;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * Related Topics 数学 二分查找
 *
 * @author tianqi.xu
 * 2020/6/11
 */
public class Square {
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long min = 1;
        long max = x / 2 + 1;
        long mid = (min + max) / 2 + 1;
        while (min <= max) {
            if (mid * mid == x) {
                return (int) mid;
            }
            if ((mid - 1) * (mid - 1) == x) {
                return (int) (mid - 1);
            }
            if (mid * mid > x && (mid - 1) * (mid - 1) < x) {
                return (int) (mid - 1);
            }
            if (mid * mid < x) {
                min = mid;
            }
            if ((mid - 1) * (mid - 1) > x) {
                max = mid;
            }
            mid = (min + max) / 2;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
    }
}
