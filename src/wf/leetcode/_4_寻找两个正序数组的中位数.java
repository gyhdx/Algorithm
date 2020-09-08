package wf.leetcode;

import java.util.ArrayList;

/*
给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。
 */
public class _4_寻找两个正序数组的中位数 {
    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid = 0;
        int flag = (nums1.length + nums2.length) / 2;
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0,j = 0;
        while (list.size() <= flag){
            if (nums1[i] > nums2[j]){
                j++;
            }else {
                i++;
            }
        }
        System.out.println();
        return mid;
    }
}
