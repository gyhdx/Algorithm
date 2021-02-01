package 秋招.水滴;

import java.util.Scanner;


public class Main2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr  = str.split(",");
        int[] b = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            b[i]=Integer.parseInt(arr[i]);
        }
        Solution solution=new Solution();
        System.out.print(solution.reversePairs(b));
    }

    private static class Solution {
        // 请在Solution中完成你的答案
        public long reversePairs(int[] nums) {
            if (nums.length <=1)return 0;
            long ens = 0;
            if (nums[0]>nums[1]){
                swap(nums,0,1);
                ens++;
            }
            for (int i = 2; i < nums.length; i++) {
                if (nums[i]<nums[0]){
                    ens +=change(nums,0,i);
                }else if (nums[i-1]<nums[i]){

                }else {
                    int start = binSearch(nums,0,i-1,nums[i]);
                    ens+=change(nums,start,i);
                }
            }
            return ens;
        }

        private int binSearch(int[] nums, int start, int end, int num) {
            while (start<end){
                int mid = (start+end)/2;
                if (nums[mid] > num){
                    end = start;
                }else {
                    start = mid+1;
                }
            }
            return start;
        }

        private long change(int[] nums, int start, int end) {
            int n = nums[end];
            long count = 0;
            while (end > start){
                nums[end] = nums[end - 1];
                end--;
                count++;
            }
            nums[start] = n;
            return count;
        }

        private void swap(int[] nums, int i, int j) {
            int mid= nums[i];
            nums[i] = nums[j];
            nums[j] = mid;
        }
    }
}
