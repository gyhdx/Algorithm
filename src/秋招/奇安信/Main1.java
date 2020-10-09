package 秋招.奇安信;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(plt(n));
    }

    private static int plt(int n) {
        int ens = 0;
        if (n<=2)return n;
        ens = 1;
        for (int i = 1; i < n; i++) {
            ens*=2;
        }
        return ens;
    }
}
