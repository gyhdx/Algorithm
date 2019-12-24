package wf.jianzhi_offer;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;

/**
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 解题思路
 *  二叉树是层次遍历
 */
public class 从上往下打印二叉树 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode treeNode = node;
        node.left = new TreeNode(3);
        node.right = new TreeNode(7);
        node = treeNode.left;
        node.left = new TreeNode(2);
        node.right = new TreeNode(4);
        node = treeNode.right;
        node.left = new TreeNode(6);
        node.right = new TreeNode(8);
        ArrayList<Integer> list = PrintFromTopToBottom(treeNode);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root==null)return list;
        ArrayList<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.get(0);
            stack.remove(0);
            if (node.left!=null)stack.add(node.left);
            if (node.right!=null)stack.add(node.right);
            list.add(node.val);
        }
        return list;
    }
}
