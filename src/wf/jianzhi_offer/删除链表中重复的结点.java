package wf.jianzhi_offer;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class 删除链表中重复的结点 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode list = listNode;
        list.next = new ListNode(2);
        list = list.next;
        list.next = new ListNode(2);
        list = list.next;
        list.next = new ListNode(4);
        list = list.next;
        list.next = new ListNode(4);
        list = null;
        ListNode listNode1 = deleteDuplication(listNode);
        print(listNode1);
    }


    public static ListNode deleteDuplication(ListNode pHead){
        if (pHead==null)return null;
        ListNode h = new ListNode(1);
        ListNode list = pHead;
        h.next=pHead;
        pHead=h;
        while (list.next!=null){
            if (h.next.val != list.next.val){
                h=h.next;
                list=list.next;
            }else {
                while (list.next!=null&&h.next.val==list.next.val){
                    list=list.next;
                }
                h.next=list.next;
                if (list.next==null)break;
                list=list.next;
            }
        }
        return pHead.next;
    }

    public static void print(ListNode listNode) {
        if (listNode != null) {

            System.out.println(listNode.val);
            print(listNode.next);
        }
    }
}
