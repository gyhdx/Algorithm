package wf.leetcode;

import java.util.Stack;

/*
给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 */
public class _230_二叉搜索树中第K小的元素 {

    public int kthSmallest(TreeNode root, int k) {


        Stack<TreeNode> queue = new Stack<>();
        while (true) {
            while (root != null) {
                queue.push(root);
                root = root.left;
            }
            root = queue.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }


}
/*
  public int kthSmallest(TreeNode root, int k) {
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

    while (true) {
      while (root != null) {
        stack.add(root);
        root = root.left;
      }
      root = stack.removeLast();
      if (--k == 0) return root.val;
      root = root.right;
    }
  }

 */
