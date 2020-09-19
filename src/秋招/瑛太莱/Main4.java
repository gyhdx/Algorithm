package 秋招.瑛太莱;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year1 = sc.nextInt();
        int year2 = sc.nextInt();
        int deadYear = sc.nextInt();
        int allYear = sc.nextInt();

        long[] list = new long[allYear +5];
        list[0]=1;
        for (int i = 0;i<allYear;i++){
            if (i>= deadYear-1){
                list[i-deadYear+1]=0;
            }
            list[i+year1-1] += list[i];
            list[i+year2-1] += list[i];
        }
        long count = 0;

        for (int i = 0; i < allYear; i++) {
            count+=list[i];
        }

        System.out.println(count);
    }
}
