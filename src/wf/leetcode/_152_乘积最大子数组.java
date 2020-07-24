package wf.leetcode;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/24 12:58
 */
/*
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class _152_乘积最大子数组 {

    public static void main(String[] args) {
//        int[] nums = {2, 3, -2, 4};
        int[] nums = {2, 3, -10, 5, -1};
//        int[] nums = {-2, 0, -1};
        System.out.println(maxProduct2(nums));
    }

    public static int maxProduct(int[] nums) {
        int deep = nums.length;
        int[] end = new int[deep];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < deep; i++) {
            end[i] = nums[i];
            if (end[i] > max) {
                max = end[i];
            }
        }

        for (int i = 1; i < deep; i++) {
            for (int j = 0; j < deep - i; j++) {
                end[j] = nums[j] * end[j + 1];
                if (end[j] > max) {
                    max = end[j];
                }
            }
        }

        return max;
    }

    // 老师的代码
    public static int maxProduct2(int[] nums) {
        int deep = nums.length;
        int[] max = new int[deep];
        int[] min = new int[deep];
        int res = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];

        for (int i = 1; i < deep; i++) {
            int num = nums[i];
            max[i] = Math.max(Math.max(max[i-1] * num,num),min[i - 1] * num);
            min[i] = Math.min(Math.min(max[i-1] * num,num),min[i - 1] * num);
            res = Math.max(max[i], res);
        }

        return res;
    }
}
