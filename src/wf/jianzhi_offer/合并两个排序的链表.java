package wf.jianzhi_offer;

/**
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class 合并两个排序的链表 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(0);//输入链表不为null的情况
        ListNode node2 = list1;
        for (int i = 2; i < 5; i=i+2) {
            ListNode node4 = new ListNode(i);
            node2.next = node4;
            node2 = node4;
        }
        ListNode list2 = new ListNode(1);//输入链表不为null的情况
        ListNode node1 = list2;
        for (int i = 3; i < 5; i=i+2) {
            ListNode node3 = new ListNode(i);
            node1.next = node3;
            node1 = node3;
        }
        print(list1);

        System.out.println("\n===============");
        print(list2);
        System.out.println("\n==============");
        ListNode merge = Merge(list1, list2);
        print(merge);
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null&&list2==null)return null;
        ListNode head=new ListNode(0);
        ListNode node=null;
        node = head;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                node.next=list1;
                list1= list1.next;
            }else {
                node.next=list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1==null){
            node.next = list2;
        }else {
            node.next = list1;
        }
        return head.next;
    }

    public static void print(ListNode listNode) {
        if (listNode != null) {
            System.out.print(listNode.val+"---");
            print(listNode.next);
        }
    }
}
