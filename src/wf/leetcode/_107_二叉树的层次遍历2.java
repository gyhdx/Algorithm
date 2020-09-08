package wf.leetcode;

import java.util.*;

public class _107_二叉树的层次遍历2 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)return lists;

        List<List<Integer>> end = new ArrayList<>();
        Queue<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);

        while (!stack.isEmpty()){
            List<Integer> ens = new ArrayList<>();
            Queue<TreeNode> stack1 = new ArrayDeque<>();
            while (!stack.isEmpty()){
                TreeNode node = stack.poll();
                ens.add(node.val);
                if (node.left != null)stack1.add(node.left);
                if (node.right != null)stack1.add(node.right);
            }
            end.add(ens);
            stack = stack1;
        }
        for (int i = end.size()-1; i >= 0; i--) {
            lists.add(end.get(i));
        }
        return lists;
    }
}
