package wf.leetcode;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/6/3 14:44
 */

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 * 解题思路：
 *
 *  判断根节点与要判断的p，q是否相同，如果相同就把根节点返回，因为根节点与其中一个数相等，那么另一个数必定是其子树中的一个节点。
 *
 *  如果根节点不相同，那么就搜寻左右子树是否包含p,q，如果左子树不包含，那么就必定再右子树中，而右子树不包含那么就必定再左子树中。否则
 *  这两个节点没有公共节点。而如果左右子树都含有p，q中的一个数，就说明p，q的最近公共节点必然是左右子树的根节点。
 */
public class _235二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        return left == null ?right:right==null?left:root;
    }
}
