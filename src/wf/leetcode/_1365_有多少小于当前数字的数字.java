package wf.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/*

给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。

换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。

以数组形式返回答案。
 */
public class _1365_有多少小于当前数字的数字 {

    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        int[] ints = smallerNumbersThanCurrent(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
//        int[] mid = new int[nums.length];
        int[] ens = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] mid = Arrays.copyOf(nums, nums.length);
        Arrays.sort(mid);
        for (int i = 0; i < mid.length; i++) {
            if (map.containsKey(mid[i]))
                continue;
            map.put(mid[i], i);
        }
        for (int i = 0; i < ens.length; i++) {
            ens[i] = map.get(nums[i]);
        }
        return ens;
    }
}
