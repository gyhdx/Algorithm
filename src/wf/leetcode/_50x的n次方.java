package wf.leetcode;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/6/8 10:11
 */

/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class _50x的n次方 {

    public static void main(String[] args) {
        System.out.println(myPow(2.10000    ,-3));
        System.out.println(myPow2(1.00000    ,-2147483648));
//        System.out.println(myPow2(2,2));
    }

    public static double myPow(double x, int n) {
        if (n ==0 )return 1;
        if (n < 0)return 1/myPow(x,-n);
        if (n % 2 == 1)return x*myPow(x,n-1);
        return myPow(x*x,n/2);
    }

    public static double myPow2(double x, int n) {
        if (n < 0){
            x=1/x;
            n=-n;
        }
        double num = 1;
        while (n != 0){
            if ((n & 1) == 1){
                num *= x;
            }
            x *= x;
            n = n >>1;
        }
        return num;
    }

    public static double myPow3(double x, int n) {
        if(x == 0.0f) return 0.0d;
        long b = n;//此处使用long，不然会有越界问题int取值范围，[−2^31, 2^31 − 1]，当输入-2^31的时候，溢出。因为好像-2^31二进制表示是全0
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }


}
