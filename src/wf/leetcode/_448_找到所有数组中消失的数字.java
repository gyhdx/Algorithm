package wf.leetcode;

import java.util.ArrayList;
import java.util.List;

/*

给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 */
public class _448_找到所有数组中消失的数字 {

    public static void main(String[] args) {
        int[] a = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(a));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            int indxe = Math.abs(nums[i])-1;
            if (nums[indxe]>0){
                nums[indxe] = nums[indxe]*-1;
            }

        }
        List<Integer> ens = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                ens.add(i+1);
            }
        }
        return ens;
    }
}
