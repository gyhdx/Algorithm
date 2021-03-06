package wf.jianzhi_offer;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * /*思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
 * * 左子树的右子树和右子树的左子树相同即可，采用递归
 * * 非递归也可，采用栈或队列存取各级子树根节点
 */

public class 对称的二叉树 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode treeNode = node;
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        System.out.println(isSymmetrical(node));

    }

    static boolean isSymmetrical(TreeNode pRoot){
        if (pRoot==null){
            return true;
        }
        return mtcah(pRoot.left,pRoot.right);
    }

    private static boolean mtcah(TreeNode left, TreeNode right) {
        if (left==null)return right==null;
        if (right==null)return false;
        if (left.val!=right.val) return false;
        return mtcah(left.left,right.right)&&mtcah(left.right,right.left);

    }
}
