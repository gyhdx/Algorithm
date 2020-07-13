package wf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/13 10:55
 */
/*

给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class _102_二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                root = queue.remove(0);
                list.add(root.val);
                if (root.left != null)queue.add(root.left);
                if (root.right != null)queue.add(root.right);
            }
            lists.add(list);
        }
        return lists;
    }
}
