package wf.jianzhi_offer;

import sun.misc.Queue;



/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、
 * 层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过
 * 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
public class 序列化二叉树 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode treeNode = node;
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node = treeNode.left;
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        node = treeNode.right;
        node.left = new TreeNode(6);
        node.right = new TreeNode(7);
        String s = Serialize(treeNode);
        System.out.println(s);
        TreeNode deserialize = Deserialize(Serialize(treeNode));
        print(deserialize);
    }

    public static void print(TreeNode listNode) {
        if (listNode != null) {

            System.out.println(listNode.val);
            print(listNode.left);
            print(listNode.right);
        }
    }

    static String Serialize(TreeNode root) {
        String ser = "";
        if (root==null)return ser;
        java.util.ArrayList<TreeNode> stack = new java.util.ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode pNode = stack.get(0);
            stack.remove(0);
            if (pNode!=null){
                stack.add(pNode.left);
                stack.add(pNode.right);
                ser+=pNode.val;
            }else {
                ser+='#';
            }
        }
        ser+='!';
        return ser;
    }
    static TreeNode Deserialize(String str) {
        char[] chars = str.toCharArray();
        int flag=1;
        java.util.ArrayList<TreeNode> stack = new java.util.ArrayList<>();
        
        TreeNode node = new TreeNode(chars[0]-'0');
        stack.add(node);
        while (!stack.isEmpty()){
            TreeNode pNode = stack.get(0);
            stack.remove(0);
            char c = chars[flag++];
            if (c == '#'){

            }else if (c=='!'){
                return node;
            }else {
                pNode.left = new TreeNode(c-'0');
                stack.add(pNode.left);
            }
            char c2 = chars[flag++];
            if (c == '#'){

            }else if (c2=='!'){
                return node;
            }else {
                pNode.right = new TreeNode(c2-'0');
                stack.add(pNode.right);
            }
        }
        return node;
    }

}
