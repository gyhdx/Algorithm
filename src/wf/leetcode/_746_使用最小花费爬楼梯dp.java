package wf.leetcode;

/*
数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。

每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。

您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 */
public class _746_使用最小花费爬楼梯dp {


    public int minCostClimbingStairs(int[] cost) {
        String s = "asd";
        String[] s1 = s.split(" ");
        if (cost.length == 0)return 0;
        if (cost.length == 1)return cost[0];
        int[] ens = new int[cost.length];
        ens[0] = cost[0];
        ens[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            ens[i] = Math.min(ens[i-1],ens[i-2]) + cost[i];
        }
        return Math.min(ens[cost.length - 1],ens[cost.length-2]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        if (cost.length == 0)return 0;
        if (cost.length == 1)return cost[0];
        int left = cost[0];
        int right = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int mid = Math.min(left,right) + cost[i];
            left = right;
            right = mid;
        }
        return Math.min(left,right);
    }
}
