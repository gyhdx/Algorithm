package wf.jianzhi_offer;

/**
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class 二叉树的镜像 {

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
        printTree(treeNode);
        System.out.println();
        Mirror(treeNode);
        printTree(treeNode);
    }

    /**
     * 交换左右子节点，直到到达叶节点
     * @param root
     */
    public static void Mirror(TreeNode root) {
        if (root==null) return;
        TreeNode p;
        p = root.left;
        root.left = root.right;
        root.right = p;
        Mirror(root.left);
        Mirror(root.right);

    }

    private static void printTree(TreeNode node) {//后序遍历输出二叉树
        if (node != null){
            System.out.print(node.val + " ");
            printTree(node.left);
            printTree(node.right);
        }
    }
}
