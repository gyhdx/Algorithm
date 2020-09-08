package wf.leetcode;

/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。
 */
public class _33_搜索旋转排序数组 {

    public static void main(String[] args) {
        int[] a = { 3,1};
//        int[] a = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search2(a, 1));
    }

    public static int search(int[] nums, int target) {
        int mid = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                mid = i + 1;
                break;
            }
        }
        int left = mid, right = mid + nums.length - 1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[getIndex(mid, nums.length)] == target) {
                return getIndex(mid, nums.length);
            } else if (nums[getIndex(mid, nums.length)] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int getIndex(int mid, int length) {
        return mid >= length ? mid - length : mid;
    }

    /*
    把数组分为两部分到有序的部分查找
     */

    public static int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            /*
            注意此处应为<=因为有可能两个表示的是同一个数
             */
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[end] >= target && nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
