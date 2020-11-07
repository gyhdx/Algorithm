package wf.leetcode;

/*
给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
 返回你可以获得的最大乘积。
 */
public class _343_整数拆分 {

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
        if (n==2)return 1;
        if (n==3)return 2;
        int[] mid = new int[n +1];
        mid[2] = 2;
        mid[3] = 3;
        for (int i = 4; i < n + 1; i++) {
            int max = 0;
            for (int j = 2; j <= (i+1)/2; j++) {
                max = Math.max(max,mid[j]*mid[i-j]);
            }
            mid[i] = max;
        }
        return mid[n];
    }
}
