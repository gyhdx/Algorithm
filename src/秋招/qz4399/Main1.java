package 秋招.qz4399;

import java.util.Arrays;

public class Main1 {

    public static void main(String[] args) {
        int[] nums = {3,4,7,11};
        int target = 11;
        int[] mix = mix(nums, target);
        for (int i = 0; i < mix.length; i++) {
            System.out.println(mix[i]);
        }
    }

    public static int[] mix(int[] nums, int target){
        if (nums.length<2)return null;
        int[] end = new int[2];

        int i = 0;
        int j = nums.length - 1;

        Arrays.sort(nums);

        while (i < j){
            if ((nums[i] + nums[j]) < target){
                i++;
            }else if ((nums[i] + nums[j]) > target){
                j--;
            }else {
                end[0] = nums[i];
                end[1] = nums[j];
                break;
            }
        }
        return end;
    }
}
