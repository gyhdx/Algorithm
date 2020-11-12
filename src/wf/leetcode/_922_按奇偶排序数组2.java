package wf.leetcode;

/*
给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。

你可以返回任何满足上述条件的数组作为答案。

 */
public class _922_按奇偶排序数组2 {

    public static void main(String[] args) {
        int[] a = {2,4,5,7};
        a = sortArrayByParityII(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static int[] sortArrayByParityII(int[] A) {
        if (A.length == 0) return A;
        int i = 0, j = 1;
        while (i < A.length && j < A.length) {
            while (i < A.length && A[i] % 2 == 0) {
                i += 2;
            }
            while (j < A.length && A[j] % 2 == 1) {
                j += 2;
            }
            if (i < A.length && j < A.length){
                int mid = A[i];
                A[i] = A[j];
                A[j] = mid;
            }
        }
        return A;
    }
}
