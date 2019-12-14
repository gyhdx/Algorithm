package wf.jianzhi_offer;

import java.util.ArrayList;



/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class 按之字形顺序打印二叉树 {

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

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot==null)return lists;
        java.util.Stack<TreeNode> s1 = new java.util.Stack();
        java.util.Stack<TreeNode> s2 = new java.util.Stack();
        int deep = 1;
        s1.push(pRoot);
        while (!s1.empty()||!s2.empty()){
            if (deep%2==1){
                ArrayList<Integer> iList = new ArrayList<>();
                while (!s1.empty()){
                    TreeNode node = s1.pop();
                    if (node!=null){
                        iList.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!iList.isEmpty()){
                    lists.add(iList);
                    deep++;
                }
            }else {
                ArrayList<Integer> iList = new ArrayList<>();
                while (!s2.empty()){
                    TreeNode node = s2.pop();
                    if (node!=null){
                        iList.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!iList.isEmpty()){
                    lists.add(iList);
                    deep++;
                }
            }
        }

        return lists;
    }
}
