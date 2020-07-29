package wf.leetcode;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/29 15:43
 */
/*
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
如果没有任何一种硬币组合能组成总金额，返回 -1。

 */
public class _322_零钱兑换 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int MAX = amount + 1;
        int[] list = new int[MAX];
        Arrays.fill(list, MAX);
        list[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    list[i] = Math.min(list[i], list[i - coins[j]] + 1);
                }
            }
        }
        return list[amount] > amount ? -1 : list[amount];
    }
}
