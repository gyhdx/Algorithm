package 秋招.growing;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine();
        if (list.length() == 0){
            System.out.println(0);
            return;
        }
        String[] split = list.split(" ");
        int[] res = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            res[i] = Integer.valueOf(split[i]);
        }
        System.out.println(lengthOfLIS(res));
    }

    public static int lengthOfLIS(int[] nums) {
        int res = 0;
        if (nums.length <= 0) return res;
        res = 1;

        int mid[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            mid[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    mid[i] = Math.max(mid[i], mid[j] + 1);
                }
            }
            res = Math.max(res, mid[i]);
        }
        return res;
    }
}
