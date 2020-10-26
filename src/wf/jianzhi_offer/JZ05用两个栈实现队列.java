package wf.jianzhi_offer;

import java.util.Scanner;
import java.util.Stack;

/*
题目描述
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class JZ05用两个栈实现队列 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution3 s = new Solution3();
        System.out.println("请输入入栈元素个数：");
        int n = sc.nextInt();
        System.out.println("请输入入栈元素");
        s.push(3);
        s.push(5);
        s.push(7);
        System.out.println(s.pop());
        for (int i = 0; i < n; i++) {
            s.push(sc.nextInt());
        }
        System.out.println("出栈");
        for (int i = 0; i < n; i++) {
            System.out.print(s.pop() + " ");
        }
    }
}

class Solution3 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}