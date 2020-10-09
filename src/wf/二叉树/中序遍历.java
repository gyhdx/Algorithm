package wf.二叉树;

import java.util.Stack;

public class 中序遍历 {

    public static void main(String[] args) {
        Tree tree = new Tree();
        zxbl(tree.root);
        System.out.println();
        zxblNon(tree.root);
    }

    public static void zxbl(TreeNode root) {
        if (root == null) return;
        zxbl(root.left);
        System.out.print(root.val + " ");
        zxbl(root.right);
    }

    public static void zxblNon(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }


    }
}
