package wf.leetcode;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/18 13:55
 */
/*
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class _69_x的平方根 {

    public static void main(String[] args) {
        System.out.println(mySqrt2(2147483647));
    }

    public static int mySqrt(int x) {
        long n = 0;
        for (long i = 1; i <= (x / 2) + 1; i++) {
            if (i*i == x){
                n = i;
                break;
            }else if (i*i >x){
                n = i-1;
                break;
            }
        }
        return (int)n;
    }

    //牛顿迭代法
    public static int mySqrt2(int x) {
        if (x <= 0)return x;
        long n = x;
        while (n > x/n){
            n = (n + x/n)/2;
        }
        return (int)n;
    }
}
