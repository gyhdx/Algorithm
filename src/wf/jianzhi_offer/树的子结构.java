package wf.jianzhi_offer;

/**
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class 树的子结构 {

    public static void main(String[] args) {

    }

    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1==null||root2==null)return false;
        return subTree(root1,root2)||subTree(root1.left,root2)||subTree(root1.right,root2);
    }

    private static boolean subTree(TreeNode root1, TreeNode root2) {
        if (root2==null)return true;
        if (root1==null)return false;
        if (root1.val==root2.val){
            return subTree(root1.left,root2.left)&&subTree(root1.right,root2.right);
        }else return false;

    }
}
