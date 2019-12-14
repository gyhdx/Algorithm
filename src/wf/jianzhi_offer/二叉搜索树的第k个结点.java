package wf.jianzhi_offer;


/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，
 * 按结点数值大小顺序第三小结点的值为4。
 */
public class 二叉搜索树的第k个结点 {

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
        TreeNode node1 = KthNode(treeNode, 3);
        System.out.println(node1.val);

    }

    static TreeNode KthNode(TreeNode pRoot, int k){
        TreeNode node = null;
        int count = 0;
        if (pRoot==null||k==0) return node;
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        while (pRoot!=null||!stack.empty()){
            while (pRoot!=null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            count++;
            node = stack.pop();
            if (count==k)return node;
            pRoot = node.right;
        }

        return null;
    }
}
