package wf.leetcode;

/*

实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class _31_下一个排列 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

//    public static void nextPermutation(int[] nums) {
//        if (nums.length == 0)return;
//        Queue<Integer> queue = new ArrayDeque<>();
////        boolean flag = true;
//        for (int i = nums.length-1; i > 0; i--) {
//            if (nums[i] > nums[i-1]){
//                int mid = nums[i];
//                nums[i] = nums[i-1];
//                nums[i-1] = mid;
//                return;
//            }else {
//                queue.add(nums[i]);
//            }
//        }
//        queue.add(nums[0]);
////        int[] ens = new int[nums.length];
//        int i = 0;
//        while (!queue.isEmpty()){
//            nums[i++] = queue.poll();
//        }
//    }

    /*
    解题思路：
        找到第一个（51632）从后往前的比后一个小的数i（1）然后从后往前找到第一个比i大的数（2）
        交换两个数的位置（52631）然后把数组从i的原位置以后到结尾进行翻转（52136）就可以得到解

        如果找不到i那i的位置是-1，说明数组递减，翻转整个链表
     */
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            int mid = nums[i];
            nums[i] = nums[j];
            nums[j] = mid;
        }
        resove(nums, i + 1);
    }

    private static void resove(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            int mid = nums[i];
            nums[i] = nums[j];
            nums[j] = mid;
            i++;
            j--;
        }
    }
}
