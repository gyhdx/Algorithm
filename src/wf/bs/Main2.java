package wf.bs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] list = new int[n];
            for (int j = 0; j < n; j++) {
                list[j] = sc.nextInt();
            }
            Arrays.sort(list);
            int p1 = 0;
            int p2 = 0;
            int thr = 0;

            for (int j = n - 1; j >= 0; j--) {
                if (p1 == p2 ){
                    thr = resout(list, j);
                    p1 = list[j--];
                    p2 = list[j];
                }else if (p1 > p2){
                    p2 += list[j];
                }else if (p1 < p2){
                    p1 += list[j];
                }
            }
            System.out.println(thr);
        }
    }

    public static int resout(int[] list, int start){
        int re = 0;
        for (int i = start; i >= 0;i--){
            re += list[i];
        }
        return re;
    }
}
