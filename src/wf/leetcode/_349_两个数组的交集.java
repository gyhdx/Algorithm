package wf.leetcode;

import java.util.Arrays;

/*
给定两个数组，编写一个函数来计算它们的交集。
 */
public class _349_两个数组的交集 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0)return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ens = new int[nums1.length+nums2.length];
        int i=0,j=0;
        int index = 0;
        while (i<nums1.length && j<nums2.length){
            int x = nums1[i];
            int y = nums2[j];
            if (x == y){
                if (index == 0 || x != ens[index-1]){
                    ens[index++] = x;
                }
                i++;
                j++;
            }else if (x<y){
                i++;
            }else {
                j++;
            }
        }
        return Arrays.copyOfRange(ens,0,index);
    }
}
