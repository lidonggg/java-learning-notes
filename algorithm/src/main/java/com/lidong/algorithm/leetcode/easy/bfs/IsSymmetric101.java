package com.lidong.algorithm.leetcode.easy.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树（简单-101）
 * 问题描述：
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * @author ls J
 * @date 2020/4/3 13:34
 */
public class IsSymmetric101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recurse(root.left, root.right);
    }

    /**
     * bfs 解法，逐层检查
     *
     * @param root root node
     */
    private boolean bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    /**
     * 递归解法(dfs)，每次检查左子树的左子树与右子树的右子树，左子树的右子树与右子树的左子树
     *
     * @param left  left node
     * @param right right node
     */
    private boolean recurse(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == null && right == null;
        }
        return left.val == right.val && recurse(left.left, right.right) && recurse(left.right, right.left);
    }


    private static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }
}
