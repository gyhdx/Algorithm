package wf.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class _46_全排列 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length <= 0) return lists;
        List<Integer> list = new ArrayList<>();
        dfs(nums, list, lists);
        return lists;
    }

    private static void dfs(int[] nums, List<Integer> list, List<List<Integer>> lists) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(nums, list, lists);
                list.remove(list.size() - 1);
            }
        }
    }
}
