package wf.kdxf;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long max = 0;

        int[][] list = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int end = getmax(list, i ,j);
                if (end > max){
                    max = end;
                }
            }
        }
        System.out.println(max);

//        pritn(list, n, m);

    }

    private static int getmax(int[][] list, int r, int l) {
        int max = 0;
        int res = list[r][l];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                if (i != r && j != l && (res*list[i][j] > max)){
                    max = list[i][j] * res;
                }
            }
        }
        return max;
    }


    public static void pritn(int[][] list, int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }
    }
}
