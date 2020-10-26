package 秋招.美团;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] score = new int[m];
        for (int i = 0; i < m; i++) {
            score[i] = sc.nextInt();
        }

        Arrays.sort(score);

        int ens = m - y - 1;

        if (ens+1 > y){
            System.out.println(-1);
        }else if (ens+1>=x && ens+1<=y){
            System.out.println(score[ens]);
        }else {
            while (true){
                if (ens+1>=x){
                    break;
                }
                ens++;
            }
            if (m-ens-1>=x&& m-ens-1<=y){
                System.out.println(score[ens]);
            }else {
                System.out.println(-1);
            }
        }

//        if (score[ens] == score[ens-1]){
//            while (ens < m && score[ens] == score[ens-1]){
//                ens++;
//            }
//            int len = m - ens - 1;
//            if (len >= x){
//                System.out.println(score[ens]);
//            }else {
//                System.out.println(-1);
//            }
//        }else if (score[ens] == score[ens+1]){
//            while (ens < m-1 && score[ens] == score[ens+1]){
//                ens++;
//            }
//            int len = m - ens - 1;
//            if (len >= x){
//                System.out.println(score[ens+1]);
//            }else {
//                System.out.println(-1);
//            }
//        }else {
//            System.out.println(score[ens]);
//        }
    }

}
