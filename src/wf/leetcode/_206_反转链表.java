package wf.leetcode;

public class _206_反转链表 {

    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next){
            return head;
        }
        ListNode root = new ListNode(-1);
        while (null != head){
            ListNode node = head;
            head = head.next;
            node.next = null;
            node.next = root.next;
            root.next = node;
        }
        return root.next;
    }
}
