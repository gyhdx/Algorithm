package 秋招.滴滴;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] end = new int[n][n];
        int snew = 1;
        int sold = 1;
        if ((n & 1) == 1) {
            int i = n / 2;
            int j = n / 2;
            end[i][i] = 1;
            int loop = 2;
            int k;
            while (loop/2 < (n / 2 + 1)) {
                j--;
                for (k = i; k < loop + i; k++) {
                    end[k][j] = snew;
                    snew = snew+sold;
                    sold = end[k][j];
                }
                i = k-1;
                j++;
                for (k = j; k < loop + j; k++) {
                    end[i][k] = snew;
                    snew = snew+sold;
                    sold = end[i][k];
                }
                j =k-1;
                i--;
                for (k = i; k > i - loop; k--) {
                    end[k][j] = snew;
                    snew = snew+sold;
                    sold = end[k][j];
                }
                i = k+1;
                j--;
                for (k = j; k > j - loop; k--) {
                    end[i][k] = snew;
                    snew = snew+sold;
                    sold = end[i][k];
                }
                j = k+1;
                loop = loop*2;
            }
        }else {
            int i = n / 2;
            int j = n / 2;
            snew = 1;
            sold = 0;
            int loop = 1;
            int k;
            while (loop/2 < n / 2) {
                j--;
                for (k = i; k < loop + i; k++) {
                    end[k][j] = snew;
                    snew = snew+sold;
                    sold = end[k][j];
                }
                i = k-1;
                j++;
                for (k = j; k < loop + j; k++) {
                    end[i][k] = snew;
                    snew = snew+sold;
                    sold = end[i][k];
                }
                j =k-1;
                i--;
                for (k = i; k > i - loop; k--) {
                    end[k][j] = snew;
                    snew = snew+sold;
                    sold = end[k][j];
                }
                i = k+1;
                j--;
                for (k = j; k > j - loop; k--) {
                    end[i][k] = snew;
                    snew = snew+sold;
                    sold = end[i][k];
                }
                j = k+1;
                loop = loop+2;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(end[i][j] + " ");
            }
            System.out.println();
        }
    }

}
