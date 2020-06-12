package com.lc.bootcamp.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * //     3
 * //    / \
 * //   9  20
 * //     /  \
 * //    15   7
 * <p>
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @author tianqi.xu
 * 2020/5/29
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> queue1 = new LinkedList<>(), queue2 = new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.remove();
                item.add(node.val);
                if (node.left != null)
                    queue2.offer(node.left);
                if (node.right != null)
                    queue2.offer(node.right);
            }
            res.add(item);
            LinkedList<TreeNode> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }
        return res;
    }
}
