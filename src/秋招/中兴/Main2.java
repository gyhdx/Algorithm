package 秋招.中兴;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int[][] bian = new int[2][m];
        for (int i = 0; i < m; i++) {
            bian[0][i] = sc.nextInt();
            bian[1][i] = sc.nextInt();
        }

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] mid = {Math.min(bian[0][i],bian[1][i]),Math.max(bian[0][i],bian[1][i])};
            if (!list.contains(mid)){
                list.add(mid);
            }
        }

        System.out.println(n - list.size() - 1);
    }
}
