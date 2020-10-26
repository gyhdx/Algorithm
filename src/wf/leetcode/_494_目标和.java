package wf.leetcode;

/*
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 */
public class _494_目标和 {

    private static int count = 0;

    public static void main(String[] args) {
        int[] s = {1, 1, 1, 1, 1};
        int targetSumWays = findTargetSumWays(s, 3);
        System.out.println(targetSumWays);
    }

    public static int findTargetSumWays(int[] nums, int S) {
        getCount(nums, S,0,0);
        return count;
    }

    private static void getCount(int[] nums, int s, int i, int sum) {
        if (i==nums.length && sum == s){
            count++;
            return;
        }else if (i==nums.length && sum != s){
            return;
        }

        sum += nums[i]; 
        getCount(nums, s, i+1,sum);
        sum -= nums[i];
        sum-=nums[i];
        getCount(nums,s,i+1,sum);
        sum+=nums[i];
    }
}
