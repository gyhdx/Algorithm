package 秋招.中兴;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] tree = new int[n];
        int[][] opt = new int[2][m];
        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            opt[0][i] = sc.nextInt();
            opt[1][i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int option = opt[0][i];
            int deep = opt[1][i];
            if (option == 1) {
                changTree(tree, deep);
            } else if (option == 2) {
                printDeep(tree, deep);
            }
        }
    }

    private static void printDeep(int[] tree, int deep) {
        int began = 1;
        int end = 1;
        for (int i = 0; i < deep - 1; i++) {
            began = began * 2;
            end = end * 2;
        }
        began = began - 1;
        end = end * 2 - 1;
        String ens = "";
        for (int i = began; i < end && i < tree.length; i++) {
            ens = ens + " " +tree[i];
        }
        System.out.println(ens.substring(1, ens.length()));

    }

    private static void changTree(int[] tree, int deep) {
        int head = deep - 1;
        int left = (head + 1) * 2 - 1;
        int right = (head + 1) * 2;
        if (left< tree.length && right<tree.length && tree[right] > tree[left]) {
            swap(tree, left, right);
        }
        if (left< tree.length && head<tree.length &&tree[left] > tree[head]) {
            swap(tree, left, head);
        }
        if (left< tree.length && right<tree.length &&tree[right] > tree[left]) {
            swap(tree, left, right);
        }
    }

    private static void swap(int[] tree, int left, int right) {
        int mid = tree[left];
        tree[left] = tree[right];
        tree[right] = mid;
    }
}
