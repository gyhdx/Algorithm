package wf.leetcode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class _98验证二叉搜索树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root));

    }

    public static boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    /**
     * 如果左子树
     * @param root
     * @param min
     * @param max
     * @return
     */
    private static boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)return true;
        if (min != null && min >= root.val)return false;
        if (max != null && max <= root.val)return false;
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
}




