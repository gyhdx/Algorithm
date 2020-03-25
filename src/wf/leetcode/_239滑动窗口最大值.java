package wf.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 *
 * 解题思路：
 * 可以使用一个双端队列，不过太复杂没有实现出来，所以使用了暴力破解，求每个窗口的最大值
 */
public class _239滑动窗口最大值 {

    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int[] nums = {1,-1};
        int[] nums = {7,2,4};
//        int[] nums = {};
        int k = 9;
        int[] ints = maxSlidingWindow(nums, k);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n*k == 0)return new int[0];
        int[] ints = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max,nums[j]);
            }
            ints[i] = max;
        }
        return ints;
    }




}
