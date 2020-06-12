package com.lc.bootcamp.array;

/**
 * @author tianqi.xu
 * 2020/6/12
 */
public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = n + m - 1; i >= 0; i--) {
            if (n == 0) {
                nums1[i] = nums1[--m];
            } else if (m == 0) {
                nums1[i] = nums2[--n];
            } else if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[i] = nums1[--m];
            } else {
                nums1[i] = nums2[--n];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3, n = 3;
        int[] nums2 = {2, 5, 6};
        merge(nums1, m, nums2, n);
    }
}
