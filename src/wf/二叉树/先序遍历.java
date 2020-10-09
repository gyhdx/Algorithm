package wf.二叉树;

import java.util.Stack;

public class 先序遍历 {

    public static void main(String[] args) {
        Tree tree = new Tree();
        xxbl(tree.root);
        System.out.println();
        xxblNon(tree.root);
    }

    public static void xxbl(TreeNode root){
        if (root == null)return;
        System.out.print(root.val + " ");
        xxbl(root.left);
        xxbl(root.right);
    }

    public static void xxblNon(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right!=null)stack.push(node.right);
            if (node.left!=null)stack.push(node.left);
        }
    }
}
