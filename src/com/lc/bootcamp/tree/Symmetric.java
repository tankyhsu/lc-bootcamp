package com.lc.bootcamp.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * //     1
 * //    / \
 * //   2   2
 * //  / \ / \
 * // 3  4 4  3
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * //    1
 * //   / \
 * //  2   2
 * //   \   \
 * //   3    3
 * <p>
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * @author tianqi.xu
 * 2020/5/27
 */
public class Symmetric {

    public static boolean isSymmetric(TreeNode root) {
        List<Integer> leftList = new LinkedList<>();
        List<Integer> rightList = new LinkedList<>();

        if (root == null) {
            return true;
        } else {
            leftFirst(root.left, leftList);
            rightFirst(root.right, rightList);
        }
        System.out.println(leftList);
        System.out.println(rightList);
        return leftList.equals(rightList);
    }

    private static void leftFirst(TreeNode root, List<Integer> leftList) {
        if (root != null) {
            leftList.add(root.val);
            if (root.left != null) {
                leftFirst(root.left, leftList);
            } else {
                leftList.add(null);
            }
            if (root.right != null) {
                leftFirst(root.right, leftList);
            } else {
                leftList.add(null);
            }
        }
    }

    private static void rightFirst(TreeNode root, List<Integer> rightList) {
        if (root != null) {
            rightList.add(root.val);
            if (root.right != null) {
                rightFirst(root.right, rightList);
            } else {
                rightList.add(null);
            }
            if (root.left != null) {
                rightFirst(root.left, rightList);
            } else {
                rightList.add(null);
            }
        }
    }

    public static void main(String[] args) {
        // [1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }
}
