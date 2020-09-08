package wf.leetcode;


import java.util.ArrayList;
import java.util.List;

/*

给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class _77_组合 {

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }

    /*
    解题思路：
        这一类题（多次循环一个队列），可以使用dfs去计算，这个题还要考虑剪枝，
        然后就是，再把旧ArrayList放入大ArrayList时一个建立一个新的ArrayList
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(1,n,k,list,lists);


        return lists;

    }

    private static void dfs(int i, int n, int k, ArrayList<Integer> list, List<List<Integer>> lists) {
        if ((list.size() + (n-i+1))<k){
            return;
        }

        if (list.size() == k){
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(i);
        dfs(i + 1, n,k,list,lists);

        list.remove(list.size() -1);
        dfs(i + 1, n,k,list,lists);
    }


}
