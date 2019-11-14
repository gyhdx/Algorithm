package wf.jianzhi_offer;

import java.io.File;

/*
题目描述
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39
 */
public class 斐波那契数列 {

    public static void main(String[] args) {
        Solution6 s  = new Solution6();
        //测试递归和循环的效率问题
        long t = System.currentTimeMillis();
        System.out.println("time bafer = "+t);
        System.out.println("循环 = " + s.Fibonacci(100));
        long s2 = System.currentTimeMillis();
        System.out.println("time after = "+s2);
        System.out.println(s2 - t);


        long t1 = System.currentTimeMillis();
        System.out.println("time bafer = "+t1);
        System.out.println("递归 = " + s.Fibonacci1(100));
        long s1 = System.currentTimeMillis();
        System.out.println("time after = "+s1);
        System.out.println(s1 - t1);
    }
}


class Solution6 {
    public int Fibonacci1(int n) {
        if (n==0) return 0;
        else if (n==1) return 1;
        else return Fibonacci(n-1) + Fibonacci(n-2);
    }
    public int Fibonacci(int n) {
        int m = 0;
        int a = 1;
        int num = m;
        for (int i = 0;i<n;i++){
//            num = a;
//            a = a + m;
//            m = num;

            a = a + m;
            m = a - m;//
        }
        return m;
    }
}