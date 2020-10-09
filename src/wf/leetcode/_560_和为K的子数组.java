package wf.leetcode;

/*
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 */
public class _560_和为K的子数组 {

    public static void main(String[] args) {
        int[] a = {1,1,1};
        System.out.println(subarraySum(a,2));
    }

    public static int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int left = 0;
        int right = 1;
        int count;
        int ens = 0;
        while (true) {
            count = nums[left] + nums[right];
            if (count < k && right < nums.length) {
                right++;
            } else if (count > k && left < nums.length) {
                left++;
            } else if (count == k) {
                ens++;
                left++;
                right++;
            }
            if ((right == nums.length && count <= k) || left == nums.length) {
                break;
            }
        }
        return ens;
    }
}
