package 秋招.去哪儿;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        if (m<n){
            System.out.println(0);
            return;
        }
//        int m = 4;
//        int n = 2;
        int mid = 1;
        int i = n;
        for (i = 1; i <= m; i++) {
            mid*=i;
        }
        int mid2 = 1;
        for (i = 2; i <= n; i++) {
            mid2 *= i;
        }
        for (i = 1; i <= m-n; i++) {
            mid2*=i;
        }
        System.out.println(mid/mid2);
    }
}
