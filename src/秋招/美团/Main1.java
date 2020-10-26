package 秋招.美团;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] nums = new int[m];

        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int ens = 0;
        for (int i = 0; i < m; i++) {
            ens+=Math.abs(i - nums[i] + 1);
        }
        System.out.println(ens);
    }
}
