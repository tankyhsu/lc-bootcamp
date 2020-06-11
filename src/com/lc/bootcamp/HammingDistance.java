package com.lc.bootcamp;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释:
 * // 1   (0 0 0 1)
 * // 4   (0 1 0 0)
 * //        ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 * <p>
 * Related Topics 位运算
 *
 * @author tianqi.xu
 * 2020/6/11
 */
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int z = x ^ y;
//        System.out.println(z);
        String str = Integer.toBinaryString(z);
//        System.out.println(str);
        int i = 0;
        for (char c : str.toCharArray()) {
            if (c == 49) i++;
        }
        return i;
    }

    /**
     * official solution
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        hammingDistance(2, 4);
    }
}
