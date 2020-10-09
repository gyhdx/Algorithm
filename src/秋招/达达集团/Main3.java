package 秋招.达达集团;

import java.util.Random;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[][] list = new int[2][m];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] split = s.split(",");
            list[0][i] = Integer.valueOf(split[0]);
            list[1][i] = Integer.valueOf(split[1]);
        }
        int[] ens = new int[m];
        ens[0] = list[1][0];
        for (int i = 1; i <m; i++) {
            ens[i] = ens[i-1]+list[1][i];
        }
        for (int i = 0; i < 10000; i++) {
            Random random = new Random();
            long x = random.nextInt(ens[m-1]);
            for (int j = 0; j < m; j++) {
                if (x<=ens[j]){
                    System.out.println(list[0][j]);
                }
            }
        }
        System.out.println();
    }
}
