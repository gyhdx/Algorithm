package wf.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。
 */
public class _39_组合总和 {

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
//        int[] candidates = {2,3,6,7};
        List<List<Integer>> lists = combinationSum(candidates, 8);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates.length <= 0)return lists;
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target,0,0,list,lists);
        return lists;
    }

    private static void dfs(int[] candidates, int target, int i, int count, List<Integer> list, List<List<Integer>> lists) {
        if (count > target || i == candidates.length){
            return;
        }

        if (count == target && !lists.contains(list)){
            lists.add(new ArrayList<>(list));
            return;
        }

        list.add(candidates[i]);
        count += candidates[i];
        dfs(candidates,target,i,count,list,lists);
        list.remove(list.size()-1);
        count -= candidates[i];
//        dfs(candidates,target,i,count,list,lists);
        if (i +1 <candidates.length){
            list.add(candidates[i +1]);
            count += candidates[i+1];
            dfs(candidates,target,i + 1,count,list,lists);
            list.remove(list.size()-1);
            count -= candidates[i+1];
            dfs(candidates,target,i + 1,count,list,lists);
        }
    }
}
