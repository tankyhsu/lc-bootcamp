package com.lc.bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * 输入: 5
 * 输出:
 * // [
 * //      [1],
 * //     [1,1],
 * //    [1,2,1],
 * //   [1,3,3,1],
 * //  [1,4,6,4,1]
 * // ]
 * Related Topics 数组
 *
 * @author tianqi.xu
 * 2020/6/23
 */
public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            Integer[] line = new Integer[i + 1];
            line[0] = 1; // 无脑加1
            line[i] = 1;
            for (int j = 1; j < i; j++) {
                line[j] = result.get(i - 1).get(j) + result.get(i - 1).get(j - 1);
            }
            result.add(Arrays.asList(line));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
