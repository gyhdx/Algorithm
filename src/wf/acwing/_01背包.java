package wf.acwing;

import java.util.Scanner;

public class _01背包 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int[] w = new int[n+1];
        int[] value = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            w[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        int[][] mid = new int[n+1][v+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= v; j++) {
                mid[i][j] = mid[i-1][j];
                if (w[i] <= j){
                    mid[i][j] = Math.max(mid[i][j], mid[i-1][j-w[i]] + value[i]);
                }
            }
        }

        System.out.println(mid[n][v]);
    }
}
