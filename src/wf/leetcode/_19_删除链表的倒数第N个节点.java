package wf.leetcode;

public class _19_删除链表的倒数第N个节点 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(1);
//        if (head.next == null)return null;
        node.next = head;
        fuzhu(node, head, n);
        return node.next;
    }

    private int fuzhu(ListNode head, ListNode next, int k) {
        if (next == null)return 0;
        int n = fuzhu(next, next.next,k) + 1;
        if (n == k){
            head.next = next.next;
        }
        return n;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode node = new ListNode(1);
        node.next = head;
        for (int i = 0; i < n ; i++) {
            head = head.next;
        }
        ListNode p = node;
        while (head != null){
            head = head.next;
            p = p.next;
        }
        p.next = p.next.next;
        return node.next;
    }
}
