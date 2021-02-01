package wf.leetcode;

/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class _283_移动零 {

    public static void main(String[] args) {
        int[] a = {0,1,0,3,12};
        moveZeroes(a);
    }

    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int i = 0;
        while (i<length){
            if (nums[i] == 0){
                for (int j = i; j < length - 1; j++) {
                    nums[j] = nums[j+1];
                }
                nums[length - 1] = 0;
                length--;
            }else {
                i++;
            }
        }
    }
}
