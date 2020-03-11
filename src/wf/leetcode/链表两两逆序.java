package wf.leetcode;


/**
 * 如：1 -> 2 -> 3 -> 4 -> 5
 * 逆序：2 -> 1 -> 4 -> 3 -> 5
 */
public class 链表两两逆序 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        head1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        head1 = nixu(head1);
        while (head1 != null){
            System.out.print(head1.val + " ");
            head1 = head1.next;
        }
    }

    public static ListNode nixu(ListNode head){
        if (head == null || head.next == null)return head;
        ListNode frist = new ListNode(-1);
        frist.next = head;
        ListNode p = frist,h,t;

        //注意链表指向问题谨防发生死循环
        while (p.next != null && p.next.next != null){
            h = p.next;
            t = h.next;

            p.next = t;
            h.next = t.next;
            t.next = h;


            p = h;

        }
        return frist.next;
    }
}
