package wf.leetcode;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/21 12:07
 */
/*
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class _231_2的幂 {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
    }

    public static boolean isPowerOfTwo(int n) {
        boolean flag = false;
        if (n <= 0) return flag;
        if ((n & (n - 1)) == 0)
            return true;
        return flag;
    }
}
