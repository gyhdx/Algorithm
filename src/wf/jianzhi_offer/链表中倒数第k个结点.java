package wf.jianzhi_offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class 链表中倒数第k个结点 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode list = listNode;
        list.next = new ListNode(2);
        list = list.next;
        list.next = new ListNode(3);
        list = list.next;
        list.next = new ListNode(4);
        list = list.next;
        list.next = new ListNode(5);
        ListNode listNode1 = FindKthToTail(listNode, 5);
        System.out.println(listNode1.val);

    }

    /**.
     * 解析：
     *  先循环遍历i到i与k相等声明p与q之间的距离就是，当p为尾节点使从p到q的要求的k距离。
     *  所有此时q和p一起向为节点遍历，当p为尾节点时q也就到了要求位置，判断i<k如果是则说明
     *  k大于链表长度，返回null，否则就把q返回
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head,int k) {
        ListNode p=head,q=head;
        int i=0;
        for (; p!=null; i++) {
            if (i>=k){
                q=q.next;
            }
            p=p.next;
        }
        return i<k?null:q;
    }
}
