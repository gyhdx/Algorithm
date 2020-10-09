package wf.二叉树;

public class Tree {

    public static TreeNode root;

    static {
        root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('C');
        TreeNode rl = root.left;
        rl.right = new TreeNode('D');
        TreeNode rr = rl.right;
        rr.left = new TreeNode('G');
        rr = root.right;
        rr.left = new TreeNode('E');
        rr.right = new TreeNode('F');
        rr = rr.right;
        rr.left = new TreeNode('H');
    }
}
