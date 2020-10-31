package wf.leetcode;

/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。
 */
public class _121_买卖股票的最佳时机 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int[] mid = new int[prices.length];
        int ens = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                if (prices[i]>prices[j]){
                    mid[j] = Math.max(mid[j], prices[i] - prices[j]);
                }
                ens = Math.max(ens, mid[j]);
            }
        }
        return ens;
    }
}
