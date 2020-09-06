package wf.leetcode;

public class _136_只出现一次的数字 {

    public static void main(String[] args) {
        int[] list = {1,1,2,2,3};
        System.out.println(singleNumber(list));
    }

    public static int singleNumber(int[] nums) {
        int ens = 0;
        for (int i = 0; i < nums.length; i++) {
            ens = ens^nums[i];
        }
        return ens;
    }
}
