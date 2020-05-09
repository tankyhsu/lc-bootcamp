package com.lc.bootcamp;

/**
 * 合并区间
 * @author tianqi.xu
 * 2020/5/9
 */
public class Concat {
    public int[][] merge(int[][] collection) {
        // 默认左区间有小到大排列
        int[][] result = {};
        // boolean isMerge;
        result[0] = collection[0];
        // 记录当前结果末端
        int length = result.length;

        for (int i = 1; i < collection.length; i++) {
            // 判断i的右区间是否大于i+1的左区间
            if (result[length - 1][1] > collection[i][0]) {
                // 发生merge
                // 比较右区间大小
                int maxRight = collection[i][1] > result[length - 1][1] ? collection[i][1] : result[length - 1][1];
//                result[length - 1] = [result[length - 1][0], maxRight];
            } else {
                // 无需融合，直接append在result中
                result[length] = collection[i];
                length++;
            }
        }
        return result;
    }
}

