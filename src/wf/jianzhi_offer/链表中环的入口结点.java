package wf.jianzhi_offer;


import java.util.ArrayList;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */



public class 链表中环的入口结点 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode list = listNode;
        ListNode list2 = listNode;
        list.next = new ListNode(2);
        list = list.next;
        list.next = new ListNode(3);
        list = list.next;
        list2=list;
        list.next = new ListNode(4);
        list = list.next;
        list.next = new ListNode(5);
        list = list.next;
        list.next=list2;
//        print(listNode);
        ListNode listNode1 = EntryNodeOfLoop(listNode);
        System.out.println(listNode1.val);


    }

    public static ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead==null||pHead.next==null){
            return null;
        }
        ListNode p1 = pHead.next;
        ListNode p2 = pHead.next.next;
        while (p1!=p2){
            if (p1.next!=null&&p2.next!=null){
                p1=p1.next;
                p2 = p2.next.next;
            }else {
                return null;
            }
        }
        p2=pHead;
        while (p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void print(ListNode listNode) {
        if (listNode != null) {

            System.out.println(listNode.val);
            print(listNode.next);
        }
    }
}
