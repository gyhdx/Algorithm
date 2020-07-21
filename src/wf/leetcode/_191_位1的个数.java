package wf.leetcode;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/21 11:55
 */
/*
写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class _191_位1的个数 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(-1));
    }

    // you need to treat n as an unsigned value
    /*
    每次的 n & (n - 1)会消除n的二进制中最后一个1
     */
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
//            if ((n ^ (n - 1)) == 1) {
//                count++;
//            }
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
