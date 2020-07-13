package wf.leetcode;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/13 10:38
 */
/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 */
public class _122_买卖股票的最佳时机2 {

    public static void main(String[] args) {
        int[] arr = {1 , 2 , 3 , 4 , 5};
//        int[] arr = {7 , 1 , 5 , 3 , 6 , 4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]){
                count += prices[i + 1] - prices[i];
            }
        }
        return count;
    }
}
