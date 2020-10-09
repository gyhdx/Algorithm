package wf.二叉树;

import java.util.Stack;

public class 后序遍历 {

    public static void main(String[] args) {
        Tree tree = new Tree();
        hxbl(tree.root);
        System.out.println();
        hxblNon(tree.root);
    }

    public static void hxbl(TreeNode root){
        if (root == null)return;
        hxbl(root.left);
        hxbl(root.right);
        System.out.print(root.val + " ");
    }

    //注意：记录上一次访问的节点
    public static void hxblNon(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode right = null;
        while (node != null || !stack.empty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            TreeNode peek = stack.peek();
            if (peek.right == null || peek.right.equals(right)){
                System.out.print(peek.val + " ");
                node = null;
                right = peek;
                stack.pop();
            }else {
                node = peek.right;
            }
        }
    }
}
