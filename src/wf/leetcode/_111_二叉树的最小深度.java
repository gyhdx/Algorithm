package wf.leetcode;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/16 13:46
 */
/*
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。
 */
public class _111_二叉树的最小深度 {

    /*
    找数的第一个叶节点，为null返回0，否则先判断左右子树是否不为空，左子树为空，就搜索右子树，右子树为空就搜索左子树
    如果两个子树都不为空，就找两颗子树的最小值。
     */
    public int minDepth(TreeNode root) {
        if (root == null)return 0;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
