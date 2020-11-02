package wf.leetcode;

/*
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class _96_不同的二叉搜索树dp {

    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }

    public static int numTrees(int n) {
        if (n <= 1)return n;

        int[] ens = new int[n+1];
        ens[0] = 1;
        ens[1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i ; j++) {
                ens[i] += ens[j]*ens[i-j-1];
            }
        }
        return ens[n];
    }
}
