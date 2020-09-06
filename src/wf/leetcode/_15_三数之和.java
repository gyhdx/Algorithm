package wf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_三数之和 {

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(a);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return lists;
//            if (nums[i] == nums[i + 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                int max = nums[i] + nums[left] + nums[right];
                if (max == 0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if (!lists.contains(list))
                        lists.add(list);
                    left++;
                    right--;
                }else if (max > 0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return lists;
    }

}
