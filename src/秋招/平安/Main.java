package 秋招.平安;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split(",");
        int[] nums = new int[split.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(split[i]);
        }

        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]){
                count++;
            }else {
                count--;
                if (count == 0){
                    num = nums[i];
                    count=1;
                }
            }
        }
        System.out.println(num);
    }
}
