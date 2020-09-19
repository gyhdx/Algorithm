package wf.newcoder;

import java.util.HashSet;
import java.util.Set;

public class 判断链表中是否有环 {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)return false;
        ListNode fast = head.next;
        ListNode slow = head.next;
        while (fast != slow){
            if (fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }else {
                return false;
            }
        }
        return true;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null)return false;
        Set<ListNode> set = new HashSet<>();
        ListNode fast = head;
        while (fast != null){
            if (!set.contains(fast)){
                set.add(fast);
                fast = fast.next;
            }else {
                return true;
            }
        }
        return false;
    }
}
