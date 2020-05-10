package com.lc.bootcamp.array;

/**
 * @author tianqi.xu
 * 2020/5/10
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] helper = new int[9][27];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char indexStr = board[i][j];
                if ('.' == indexStr) {
                    continue;
                }
                indexStr -= 49;
                int innerIndex = j / 3 * 3 + i / 3;
                if (helper[indexStr][i] > 0 || helper[indexStr][j + 9] > 0
                        || helper[indexStr][innerIndex + 18] > 0) {
                    return false;
                }
                helper[indexStr][i] = 1;
                helper[indexStr][j + 9] = 1;
                helper[indexStr][innerIndex + 18] = 1;
            }
        }
        return true;
    }
}