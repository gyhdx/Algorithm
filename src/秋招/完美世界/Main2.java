package 秋招.完美世界;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        int result = search(nums, target);

        System.out.println(result);
    }

    public static int search(int[] nums, int target) {
//todo 实现算法
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}
