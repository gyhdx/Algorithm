package 秋招.growing;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] a = {100,4,200,2,1,3};
        System.out.println(longestConsecutive(a));
    }
    /**
     * 从未排序的数组中找到最长的连续序列长度
     * @param nums int整型一维数组 排序的数组
     * @return int整型
     */
    public static int longestConsecutive (int[] nums) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                int left = map.get(nums[i]-1)==null?0:map.get(nums[i]-1);
                int right = map.get(nums[i] + 1)==null?0:map.get(nums[i] + 1);
                int length = 1+left+right;
                count = Math.max(count,length);
                map.put(nums[i],length);
                map.put(nums[i]-left,length);
                map.put(nums[i]+right,length);
            }
        }
        return count;
    }
}
