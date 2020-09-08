package wf.leetcode;

public class _141_环形链表 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)return false;
        ListNode slow = head, fast = head.next.next;
        while (slow != fast){
            //只检查fast及其下一个节点是否为null，因为若链表无环fast必然先到null
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
