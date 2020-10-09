package 秋招.米忽悠;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
//        int m = 8;
//        int n = 5;
        if (m==1 && n==1){
            System.out.println('A');
            return;
        }
        char[][] ens = new char[m][n];
        int a = 'A';
//        ens[0][0] = (char) a;

        int cyco = (Math.min(n, m) + 1) / 2;
        int ceng = 1;
        int x = 0;
        int y = 0;
        while (ceng <= cyco) {
            int i;
            for (i = 0; i < ens[0].length - (ceng - 1) * 2 - 1; i++) {
                ens[x][y + i] = (char) a;
                if (a == 'Z') {
                    a = 'A' - 1;
                }
                a++;
            }
            y = y + i;
            for (i = 0; i < ens.length - (ceng - 1) * 2 - 1; i++) {
                ens[x + i][y] = (char) a;
                if (a == 'Z') {
                    a = 'A' - 1;
                }
                a++;
            }
            x = x + i;
            for (i = 0; i < ens[0].length - (ceng - 1) * 2 - 1; i++) {
                if (ens[x][y - i] == '\u0000') {
                    ens[x][y - i] = (char) a;
                    if (a == 'Z') {
                        a = 'A' - 1;
                    }
                    a++;
                }
            }
            y = y - i;
            for (i = 0; i < ens.length - (ceng - 1) * 2 - 1; i++) {
                if (ens[x-i][y] == '\u0000') {
                    ens[x - i][y] = (char) a;
                    if (a == 'Z') {
                        a = 'A' - 1;
                    }
                    a++;
                }
            }
            x = x - i + 1;
            y++;
            ceng++;

        }

        printSet(ens);
    }

    private static void printSet(char[][] ens) {

        for (int i = 0; i < ens.length; i++) {
            for (int j = 0; j < ens[0].length; j++) {
                System.out.print(ens[i][j] + " ");
            }
            System.out.println();
        }
    }
}
