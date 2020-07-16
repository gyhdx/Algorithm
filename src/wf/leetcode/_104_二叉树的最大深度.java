package wf.leetcode;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/16 13:43
 */
/*
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。
 */
public class _104_二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        return root==null ? 0 : 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
