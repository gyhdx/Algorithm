package wf.jianzhi_offer;

/**
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 解题思路：
 *  先以中序遍历找到其最小值作为链表头节点，在进行判断；
 */

public class 二叉搜索树与双向链表 {
    public static void main(String[] args) {

    }


    public static TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode head = pRootOfTree;

        if (pRootOfTree == null)return head;

        boolean isHead = true;
        TreeNode node = pRootOfTree;
        TreeNode pre = null;

        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (isHead){
                head = node;
                pre = node;
                isHead = false;
            }else {
                pre.right = node;
                node.left = pre;
                pre = node;
            }
            node = node.right;
        }

/*      if(root==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                root = p;// 将中序遍历序列中的第一个节点记为root
                pre = root;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return root;
 */
        return head;

    }
}
