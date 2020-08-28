package 秋招.bs360;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        short[] p = new short[n];
        boolean[] t = new boolean[m];

        for (int i = 0; i < n; i++) {
            p[i] = (short) (i + 1);
        }

        for (int i = 0; i < m; i++) {
            if (sc.nextInt() == 1){
                t[i] = true;
            }else {
                t[i] = false;
            }
        }

        for (int i = 0; i < m; i++) {
            if (t[i] ){
                short flag = p[0];
                for (int j = 0; j < n - 1; j++) {
                    p[j] = p[j + 1];
                }
                p[n-1] = flag;
            }else {
                for (int j = 0; j < n ; j = j + 2) {
                    swap(p,j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(p[i] + " ");
        }
    }

    private static void swap(short[] p, int j) {
        short flag = p[j];
        p[j] = p[j+1];
        p[j+1]=flag;
    }
}
