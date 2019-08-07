package wf.jianzhi_offer;
import java.util.ArrayList;
/*
题目描述：

输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。

 解题思路：

 题目要求逆序输出链表的值，故最先想到的就是定义一个栈，把链表顺序遍历一遍，
 并把每个值，存入栈中，然后把栈中的值一一取出放入ArrayList中，最后返回结合即可；

 不过既然想到了栈，那么方法的递归也是依赖于栈实现的， 所以第二种方法就是，先在
 类中定义一个ArrayList；然后在方法中先判断形参中的链表是否为空，若不为空，就先调用
 方法把链表的写一个参数（listNode.next）传入，然后再把形参对象的值（listNode.val）放入
 数组集合中； 因为递归的特性，所以必然是链表结尾的值先进入集合中。
  */

class ListNode {//这是题目给的

    int val;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
}

public class 从尾到头打印链表 {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node = new ListNode(0);//输入链表不为null的情况
        ListNode node2 = node;
        for (int i = 1; i < 5; i++) {
            ListNode node1 = new ListNode(i);
            node2.next = node1;
            node2 = node1;
        }
        ArrayList<Integer> integers = s.printListFromTailToHead(node);
        System.out.println(integers);
        for (Integer i:integers){
            System.out.print(i + " ");
        }
        System.out.println("------------");
        ListNode s1 = null;//输入链表为null的情况
        s.list = new ArrayList<>();
        ArrayList<Integer> integers1 = s.printListFromTailToHead(s1);
        System.out.println(integers1);


    }
}

class Solution {

    public ArrayList<Integer> list = new ArrayList();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        /*
        错误解法：
        因为不能确定listNode是否为null，所以不能在不判断listNode是否为null的情况下
        直接调用listNode中的变量或方法，故list.add(listNode.val);应该写在if内部
        if (listNode != null){
            printListFromTailToHead(listNode.next);
        }
        list.add(listNode.val);
        */
        return list;
    }
}