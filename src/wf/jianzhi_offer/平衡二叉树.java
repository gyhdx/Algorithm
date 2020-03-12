package wf.jianzhi_offer;

/**
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 解题思路：
 *  自底向上判断树中节点左右子树高度差是否大于1，如果大于一直接返回-1不是树不是平衡二叉树，否则返回树的高度
 *
 */
public class 平衡二叉树 {

    public static void main(String[] args) {

    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        return deep(root) != -1;
    }

    private static int deep(TreeNode root) {
        if (root == null)return 0;
        int left = deep(root.left);
        if (left == -1)return -1;
        int right = deep(root.right);
        if (right == -1)return -1;
        return Math.abs(left - right) > 1?-1:Math.max(left,right);
    }
}
