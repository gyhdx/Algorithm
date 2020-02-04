package wf.jianzhi_offer;

import java.util.Random;

/**
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

public class 复杂链表的复制 {

    public static void main(String[] args) {
        复杂链表的复制 a = new 复杂链表的复制();
        RandomListNode phead = new RandomListNode(1);
        RandomListNode p1 = new RandomListNode(2);
        RandomListNode p2 = new RandomListNode(3);
        RandomListNode p3 = new RandomListNode(4);
        phead.next = p1;
        p1.next = p2;
        p2.next = p3;
        phead.random = p2;
        p3.random = phead;
        RandomListNode clone = a.Clone(phead);
    }

    public RandomListNode Clone(RandomListNode pHead){
        if (pHead==null)return pHead;
        creat(pHead);
        link(pHead);
        return remove(pHead);

    }

    private RandomListNode remove(RandomListNode pHead) {
        RandomListNode head = pHead.next;
        while (pHead != null){
            RandomListNode p = pHead.next;
            pHead.next = p.next;
            p.next = p.next == null ? null : pHead.next.next;
            pHead = pHead.next;
        }
        return head;
    }

    private void link(RandomListNode pHead) {
        while (pHead!=null){
            RandomListNode p = pHead.next;
            if (pHead.random != null){
                p.random = pHead.random.next;
            }
            pHead = p.next;
        }
    }

    private void creat(RandomListNode pHead) {
        while (pHead!=null){
            RandomListNode p = new RandomListNode(pHead.label);
            p.next = pHead.next;
            pHead.next = p;
            pHead = p.next;
        }
    }
}
