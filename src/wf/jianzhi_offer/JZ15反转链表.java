package wf.jianzhi_offer;

/**
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class JZ15反转链表 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
//        ListNode list = listNode;
//        list.next = new ListNode(2);
//        list = list.next;
//        list.next = new ListNode(3);
//        list = list.next;
//        list.next = new ListNode(4);
//        list = list.next;
//        list.next = new ListNode(5);
        ListNode listNode1 = ReverseList(listNode);
        print(listNode1);
    }

    /**
     * 头插法
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
        ListNode hesdList=null;
        if (head==null){
            return hesdList;
        }

        while (head!=null){
            ListNode node = head;
            head = head.next;
            node.next=hesdList;
            hesdList = node;
        }
        return hesdList;
    }


    public static void print(ListNode listNode) {
        if (listNode != null) {

            System.out.println(listNode.val);
            print(listNode.next);
        }
    }
}
