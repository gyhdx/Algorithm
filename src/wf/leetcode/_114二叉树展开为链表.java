package wf.leetcode;

import java.util.Stack;

public class _114二叉树展开为链表 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        flatten(root);
        while (root.right != null){
            System.out.println(root.val);
            root = root.right;
        }
    }

    public static void flatten(TreeNode root) {
        if (root == null)return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode p = root;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.right != null)stack.push(node.right);
            if (node.left != null)stack.push(node.left);
            if (!(p == node)){
                p.left = null;
                p.right = node;
                p = p.right;
            }
        }

    }
}
