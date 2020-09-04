package wf.leetcode;

public class _2_两数相加 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
    }

    /*
    两条链表每个节点的值相加，若节点值为null，用0代替；
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        int mid = 0;
        ListNode tail = head;
        while (l1 != null || l2 != null){
            int n = (l1!=null?l1.val:0) + (l2!=null?l2.val:0)+mid;
            mid = n/10;
            tail.next =  new ListNode(n % 10);
            tail = tail.next;
            if(l1!=null)l1 = l1.next;
            if(l2!=null)l2 = l2.next;
        }
        if (mid != 0){
            tail.next = new ListNode(mid);
        }
        return head.next;
    }
}
