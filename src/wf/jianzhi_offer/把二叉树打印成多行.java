package wf.jianzhi_offer;

import java.util.ArrayList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class 把二叉树打印成多行 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode treeNode = node;
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node = treeNode.left;
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        node = treeNode.right;
        node.left = new TreeNode(7);
        node.right = new TreeNode(8);
        ArrayList<ArrayList<Integer>> print = Print(treeNode);
        System.out.println(print);
    }

    static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        deep(pRoot,1,list);
        return list;

    }

    private static void deep(TreeNode pRoot, int i, ArrayList<ArrayList<Integer>> list) {
        if (pRoot==null)return;
        if (i>list.size())list.add(new ArrayList<Integer>());
        list.get(i-1).add(pRoot.val);
        deep(pRoot.left,i+1,list);
        deep(pRoot.right,i+1,list);
    }
}
