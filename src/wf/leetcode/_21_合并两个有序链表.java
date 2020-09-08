package wf.leetcode;

public class _21_合并两个有序链表 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(3);
        n1.next.next = new ListNode(5);
        ListNode n2 = new ListNode(2);
        n2.next = new ListNode(4);
        n2.next.next = new ListNode(6);
        mergeTwoLists(n1,n2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode node1 = l1, node2 = l2,node = head;
        while (node1 != null && node2 != null){
            if (node1.val > node2.val){
                node.next = node2;
                node = node.next;
                node2 = node2.next;
            }else {
                node.next = node1;
                node = node.next;
                node1 = node1.next;
            }
        }
        if (node1 == null){
            node.next = node2;
        }
        if (node2 == null){
            node.next = node1;
        }
        return head.next;
    }
}
