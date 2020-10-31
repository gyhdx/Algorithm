package wf.leetcode.面试题;

/*
给定一个整数数组，找出总和最大的连续数列，并返回总和。
 */
public class _16_17_连续数列 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0)return 0;
        int ens = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum < 0){
                sum = nums[i];
            }else {
                sum += nums[i];
            }
            ens = Math.max(ens, sum);
        }
        return ens;
    }
}
