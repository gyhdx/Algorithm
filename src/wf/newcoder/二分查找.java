package wf.newcoder;

/*
题目描述
请实现有重复数字的有序数组的二分查找。
输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
 */

public class 二分查找 {

    public static void main(String[] args) {
        int[] a = {1,1,2,3,7,7,7,9,9,10};
        int i = upper_bound_(10, 2, a);
        System.out.println(i);
    }

    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int ens = -1;
        int i = 0,j = n - 1,mid;
        while (i<j){
            mid = (i+j)/2;
            if (a[mid] >= v){
                j = mid;
            }else {
                i = mid +1;
            }
        }

        if (a[i] == v){
            return i + 1;
        }else {
            return n + 1;
        }
    }
}
