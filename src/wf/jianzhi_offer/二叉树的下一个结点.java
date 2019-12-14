package wf.jianzhi_offer;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历
 * 顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class 二叉树的下一个结点 {

    public static void main(String[] args) {
        TreeLinkNode pnode = new TreeLinkNode(1);
        TreeLinkNode node = pnode;
        pnode.left = new TreeLinkNode(2);
        pnode.left.next=node;
        pnode.right = new TreeLinkNode(3);
        pnode.right.next=node;
        pnode = pnode.left;
        pnode.left = new TreeLinkNode(4);
        pnode.left.next = pnode;
        pnode.right = new TreeLinkNode(5);
        pnode.right.next = pnode;
        pnode=pnode.right;
        TreeLinkNode node1 = GetNext(pnode);
        System.out.println(node1.val);


    }

    public static TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode == null){
            return null;
        }
        if (pNode.right!=null){
            pNode=pNode.right;
            while (pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next!=null){
            TreeLinkNode node = pNode.next;

            if (pNode == node.left){
                return node;
            }
            pNode=pNode.next;
        }
        return null;
    }
}
