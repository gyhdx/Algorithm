package wf.jianzhi_offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列
 * 对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * 解题思路：
 *  实现一遍入栈序列的压栈顺序，按入栈顺序压栈直到把出栈顺序的第一个数字压入栈顶为止，出栈，
 *  然后依次通过压入栈的值来判断是否为出栈序列的元素，如果是就出栈，不是则继续压栈，重复周期点操作，直到
 *  把所有元素压入栈为止。最后判断栈是否为空如果为空说明出栈顺序是入栈顺序的出栈顺序。
 */
public class 栈的压入_弹出序列 {

    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop = {4,3,5,1,2};
//        int[] pop = {4,5,3,2,1};
        System.out.println(IsPopOrder(push, pop));

    }

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length==0)return false;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0,j=0; i < pushA.length; i++) {
            list.add(pushA[i]);
            while (j<popA.length&&list.get(list.size()-1)==popA[j]){
                list.remove(list.size()-1);
                j++;
            }
        }

        return list.isEmpty();
    }
}
