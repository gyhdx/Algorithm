package wf.leetcode;

/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class _53_最大子序和 {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int ens = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum <0 ){
                sum = nums[i];
            }else {
                sum+=nums[i];
            }
            ens = Math.max(ens, sum);
        }
        return ens;
    }
}
