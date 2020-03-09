package wf.jianzhi_offer;

/**
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class 二叉树的深度 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode treeNode = node;
        node.left = new TreeNode(3);
        node.right = new TreeNode(7);
        node = treeNode.left;
        node.left = new TreeNode(2);
        node.right = new TreeNode(4);
        node = treeNode.right;
        node.left = new TreeNode(6);
        node.right = new TreeNode(8);
        System.out.println(TreeDepth(treeNode));
    }

    public static int TreeDepth(TreeNode root) {
        if (root == null)return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int deep = Math.max(left, right);
        return deep + 1;
    }
}
