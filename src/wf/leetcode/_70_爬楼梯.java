package wf.leetcode;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/22 15:02
 */
/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。
 */
public class _70_爬楼梯 {

    public static void main(String[] args) {
        long began = System.nanoTime();
        System.out.println(climbStairs2(100));
//        System.out.println(climbStairs(100));
        System.out.println("使用时间：" + (System.nanoTime() - began));
    }

    public static int climbStairs(int n) {
        int[] end = new int[n + 3];
        end[0] = 0;
        end[1] = 1;
        end[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            end[i] = end[i - 1] + end[i - 2];
        }
        return end[n];
    }

    public static int climbStairs2(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStairs2(n-1) + climbStairs2(n-2);
    }
}
