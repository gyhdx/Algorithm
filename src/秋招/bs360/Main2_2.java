package 秋招.bs360;

import java.util.Scanner;

public class Main2_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Node head = new Node(0);
        Node tail = null;

//        short[] p = new short[n];
        boolean[] t = new boolean[m];

        Node node = head;
        for (int i = 0; i < n; i++) {
            tail = new Node(i + 1);
            node.next = tail;
            node = node.next;
        }

        for (int i = 0; i < m; i++) {
            if (sc.nextInt() == 1){
                t[i] = true;
            }else {
                t[i] = false;
            }
        }

        for (int i = 0; i < m; i++) {
            if (t[i] ){
                if (tail.next != null){
                    tail = tail.next;
                }
                node = head.next;
                head.next = head.next.next;
                node.next = null;
                tail.next = node;
                tail = tail.next;
            }else {
                Node point = head;
                int k = 0;
                while (k < n/2){
                    node = point.next;
//                    node.next = null;
                    point.next = point.next.next;
                    node.next = point.next.next;
                    point.next.next = node;
                    point = node;
                    k++;
                }
            }
        }
        node = head.next;
        while (node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
