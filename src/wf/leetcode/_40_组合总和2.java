package wf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
 */
public class _40_组合总和2 {

    public static void main(String[] args) {
        int[] ca = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(ca, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates.length <= 0 || target < 0) return lists;
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<>();
        dfs(candidates, 0, 0, target, list, lists);
        return lists;
    }

    private static void dfs(int[] candidates, int i, int count, int target, ArrayList<Integer> list, List<List<Integer>> lists) {
        if (target == count) {
            lists.add(new ArrayList<>(list));
            return;
        }
        if (count > target || i == candidates.length) {
            return;
        }
        if ((i - 1 >= 0 && !(candidates[i] == candidates[i - 1])) || list.contains(candidates[i]) || i ==0 ){
            list.add(candidates[i]);
            count = count + candidates[i];
            dfs(candidates, i + 1, count, target, list, lists);
            list.remove(list.size() - 1);
            count -= candidates[i];
        }
        dfs(candidates, i + 1, count, target, list, lists);
    }
}
