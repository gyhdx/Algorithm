package wf.leetcode;

import java.util.Arrays;

/*
给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。

如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。

请你返回排序后的数组。
 */
public class _1356_根据数字二进制下1的数目排序 {

    public int[] sortByBits(int[] arr) {
        int[] ens = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ens[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(ens);
        for (int i = 0; i < ens.length; i++) {
            ens[i] = ens[i] % 10000000;
        }
        return ens;
    }
}
