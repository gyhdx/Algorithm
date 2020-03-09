package wf.jianzhi_offer;

/**
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */

public class 两个链表的第一个公共结点 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(7);
        ListNode n6 = new ListNode(8);
        ListNode n7 = new ListNode(9);
        ListNode n8 = new ListNode(12);
        head1.next = n2;
        n2.next = n4;
        n4.next = n6;
        n6.next = n7;
        n7.next = n8;
        head2.next = n3;
        n3.next = n5;
        n5.next = n7;
        System.out.println(FindFirstCommonNode(head1, head2).val);
        while (head1 != null){
            System.out.print(head1.val + " ");
            head1 = head1.next;
        }
        System.out.println();
        while (head2 != null){
            System.out.print(head2.val + " ");
            head2 = head2.next;
        }


    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1,p2 = pHead2;
        while (p1 != p2){
            p1 = (p1!=null?p1.next:pHead2);
            p2 = (p2!=null?p2.next:pHead1);
        }
        return p1;
    }
}
