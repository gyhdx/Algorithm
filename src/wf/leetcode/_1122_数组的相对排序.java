package wf.leetcode;

import java.util.Arrays;

/*
给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

[33,22,48,4,39,36,41,47,15,45]
[22,33,48,4]
 */
public class _1122_数组的相对排序 {

    public static void main(String[] args) {
//        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
//        int[] arr2 = {2,1,4,3,9,6};

        int[] arr1 = {33,22,48,4,39,36,41,47,15,45};
        int[] arr2 = {22,33,48,4};
        int[] ints = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int length = arr1.length;
        int length2 = arr2.length;
        Arrays.sort(arr1);
        if (length2 == 0)return arr1;
        int i = 0;
        for (int num : arr2) {
            i = sort(arr1,num,i);
        }
        return arr1;
    }

    private static int sort(int[] arr1, int num, int i) {
        int began = i,end = arr1.length - 1;
        while (began < end){
            int z = (began + end)/2;
            if (arr1[z]>=num){
                end = z;
            }else {
                began = z+1;
            }
        }
        int mid = began;
        int x = mid;
        while (x+1<arr1.length && arr1[x] == arr1[x+1]){
            x++;
        }
        while (mid > i){
            arr1[x--] = arr1[--mid];
        }
        while (i<=x){
            arr1[i++] = num;
        }
        return i;
    }
}
