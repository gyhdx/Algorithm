package wf.jianzhi_offer;

/*
题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
则重建二叉树并返回

解题思路：
    给出先序和中序遍历的数组，那么根据二叉树的特性，就可以重建二叉树

收获：
    通过本题，和从尾到头打印链表题，我了解到了关于栈的题可以优先考虑
    使用递归，而思考问题时，不要急要捋清思路，才能做好算法题。当然常见的数据结构
    及其特性也应该掌握清楚
 */
public class 重建二叉树 {

    public static void main(String[] args) {
        int[] in = {4,7,2,1,5,3,8,6};
        int[] pre = {1,2,4,7,3,5,6,8};
        TreeNode node = new Solution2().reConstructBinaryTree(pre,in);
        printTree(node);
        System.out.println();
    }

    private static void printTree(TreeNode node) {//后序遍历输出二叉树
        if (node != null){

            printTree(node.left);
            printTree(node.right);System.out.print(node.val + " ");
        }
    }
    /*
    out：
        7 4 2 5 8 6 3 1
     */

}


//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution2 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return buildBinaryTree(pre,0,pre.length - 1,in,0,in.length - 1);
    }

    public TreeNode buildBinaryTree(int [] pre, int strPre, int endPre,int [] in, int strIn, int endIN) {
//        System.out.print(1 + "  ");
        if (strIn > endIN || strPre > endPre) return null;//判断数组是否已近遍历完成
        TreeNode node = new TreeNode(pre[strPre]);//因为先序遍历的特性可知，其数组开头就是该数组的根节点
        for (int i = strIn; i <= endIN; i++) {//i = strIn是因为在递归遍历的过程中，不能确定中序遍历数组的开始位置
            if (pre[strPre] == in[i]){//找出根节点在中序遍历数组中的位置，以便划分根节点的左右子树
                node.left = buildBinaryTree(pre,strPre + 1,strPre + i - strIn,in,strIn,i - 1);//strPre + i - strIn;减strIn是因为i是从strIn开始的
                node.right = buildBinaryTree(pre,strPre + i + 1 -strIn,endPre,in,i + 1,endIN);
                break;
            }
        }
        return node;
    }
}