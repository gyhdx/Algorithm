package wf.leetcode.面试题;

/*
假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class _63_股票的最大利润 {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1)return 0;
        int ens = 0;

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (prices[i]>prices[j]){
                    ens = Math.max(ens, prices[i] - prices[j]);
                }
            }
        }
        return ens;
    }
}
