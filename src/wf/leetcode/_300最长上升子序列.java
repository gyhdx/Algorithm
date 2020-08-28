package wf.leetcode;

public class _300最长上升子序列 {

    public static void main(String[] args) {
        int[] list = {0};
//        int[] list = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(list));
    }

    public static int lengthOfLIS(int[] nums) {
        int res = 0;
        if (nums.length <= 0) return res;
        res = 1;

        int mid[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            mid[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    mid[i] = Math.max(mid[i], mid[j] + 1);
                }
            }
            res = Math.max(res, mid[i]);
        }
        return res;
    }
}
