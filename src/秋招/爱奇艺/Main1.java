package 秋招.爱奇艺;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();

        long end = 1;
//        List<Integer> end2 = new ArrayList<>();
//        List<Integer> end5 = new ArrayList<>();
//        List<Integer> end10 = new ArrayList<>();
//
////        for (int i = 1; i <= m; i++) {
////            if (i & 1 == )
////        }
//
//        for (int i = 1; i <= m; i++) {
//            end = end * i;
//        }
        end = m/5;
        if (m >= 25){
            end = end + 1;
        }
        if (m >= 125){
           end = end + 2;
        }
        if (m >= 625){
            end = end + 3;
        }
        if (m >= 3125){
            end = end + 4;
        }
        if (m >= 15625){
            end = end + 5;
        }
        System.out.println(end);
//        System.out.println(1000000/64);
    }
}
