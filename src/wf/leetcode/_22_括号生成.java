package wf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/16 14:13
 */
/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class _22_括号生成 {
    public static void main(String[] args) {
        _22_括号生成 a = new _22_括号生成();
        List<String> list = a.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        gen(0,0,n,list,"");
        return list;
    }

    private void gen(int left, int right, int n, List<String> list, String res) {
        if (left == n && right == n){
            list.add(res);
            return;
        }
        if (left < n)
            gen(left + 1, right, n, list, res+"(");
        if (left > right && right < n)
            gen(left, right + 1, n, list, res + ")");
    }
}
