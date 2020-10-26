package wf.leetcode;

import java.util.ArrayList;

/*
请判断一个链表是否为回文链表。
 */
public class _234_回文链表 {


    public boolean isPalindrome(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left <= right){
            if (list.get(left).val != list.get(right).val){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
