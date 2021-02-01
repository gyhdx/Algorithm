package 秋招.水滴;

import java.util.Scanner;

public class Main {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode p = root;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        ListNode node = root;

        while (p.next != null){
            node = node.next;
            p = p.next;
        }
        node.next = node.next.next;
        return root.next;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String inputStr = cin.nextLine();
//        while(cin.hasNextLine()) {
//            inputStr = cin.nextLine();
//        }
        String[] split = inputStr.split(";");
        String listNodeStr = split[0];
        String[] listNodes = listNodeStr.split(",");
        ListNode listNode = new ListNode(Integer.parseInt(listNodes[0]));
        ListNode tempNode = listNode;
        for (int i = 1; i < listNodes.length; i++) {
            ListNode currNode = new ListNode(Integer.parseInt(listNodes[i]));
            tempNode.next = currNode;
            tempNode = currNode;
        }
        ListNode res = removeNthFromEnd(listNode, Integer.parseInt(split[1]));
        while (true) {
            System.out.print(res.val);
            if(res.next == null) {
                break;
            }
            System.out.print(",");
            res = res.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
