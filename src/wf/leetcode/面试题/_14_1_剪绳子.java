package wf.leetcode.面试题;

/*
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1）
，每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1]
可能的最大乘积是多少？例如，当绳子的长度是8时，
我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

 */
public class _14_1_剪绳子 {

    public static void main(String[] args) {
        System.out.println(cuttingRope(4));
    }

    public static int cuttingRope(int n) {
        if (n<=1)return 0;
        if (n==2)return 1;
        if (n==3)return 2;
        long[] ens = new long[n+1];
        ens[1] = 1;
        ens[2] = 2;
        ens[3] = 3;
        for (int i = 4; i <= n; i++) {
            long max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max,ens[j]*ens[i-j]);
            }
            ens[i] = max;
        }
        return (int)ens[n]%1000000007;
    }
}
