package wf.leetcode;

/*
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。

 */
public class _213_打家劫舍2dp {

    /*
    计算带首节点不带尾节点和带尾节点不带首节点两种情况的最大值
     */
    public int rob(int[] nums) {
        if(nums.length == 0)return 0;
        if (nums.length == 1)return nums[0];
        if (nums.length == 2)return Math.max(nums[0],nums[1]);
        return Math.max(dp(nums,0,nums.length-1),dp(nums,1,nums.length));
    }

    private int dp(int[] nums, int left, int right) {
        int x = nums[left];
        int y = Math.max(nums[left], nums[left+1]);
        int ens = y;
        for (int i = left+2; i < right; i++) {
            ens = Math.max(x+nums[i],y);
            x = y;
            y = ens;
        }
        return ens;
    }
}
