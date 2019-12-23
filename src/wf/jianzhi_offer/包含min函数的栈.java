package wf.jianzhi_offer;

import java.util.Stack;

/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

public class 包含min函数的栈 {

    Stack<Integer> data = new Stack<>();
    Stack<Integer> mins = new Stack<>();

    public void push(int node) {
        data.push(node);
        if (mins.empty()||node<=mins.peek()){
            mins.push(node);
        }
    }

    public void pop() {
        if (data.peek()==mins.peek()){
            mins.pop();
        }
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return mins.peek();
    }

    public static void main(String[] args) {
        包含min函数的栈 s = new 包含min函数的栈();
        s.push(5);
        System.out.println(s.min());
        s.push(3);
        s.push(6);
        System.out.println(s.min());
        s.pop();
        s.pop();
        System.out.println(s.min());
    }
}
