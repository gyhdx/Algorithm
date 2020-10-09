package 秋招.达达集团;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int todo = sc.nextInt();
        int m = sc.nextInt();
        int[][] list = new int[2][m];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] split = s.split(",");
            list[0][i] = Integer.valueOf(split[0]);
            list[1][i] = Integer.valueOf(split[1]);
        }
        String s = sc.nextLine();
        String[] split = s.split(",");
        int began = Integer.valueOf(split[0]);
        int end = Integer.valueOf(split[1]);
        if (todo == 1){
            findIn(list,began,end);
        }else if (todo == 2){
            findMix(list,began,end);
        }
    }

    private static void findMix(int[][] list, int began, int end) {
        for (int i = 0; i < list[0].length; i++) {
            if (list[0][i]<=end && list[1][i]>=began){
                System.out.println(list[0][i]+","+list[1][i]);
            }
        }
    }

    private static void findIn(int[][] list, int began, int end) {
        for (int i = 0; i < list[0].length; i++) {
            if (list[0][i]>=began && list[1][i]<=end){
                System.out.println(list[0][i]+","+list[1][i]);
            }
        }
    }
}
/*
1
5
1,30
2,22
17,24
14,29
13,45
13,32

2
5
15,20
4,12
17,24
14,29
23,45
13,22
 */
