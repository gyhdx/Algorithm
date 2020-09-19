package 秋招.微博;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine();
        if (list.length() == 1) {
            System.out.println(true);
            return;
        }
        char[] chars = list.toCharArray();
        quickSort(chars, 0, chars.length - 1);

        for (int i = 1; i < list.length(); i++) {
            if (chars[i] == chars[i - 1]) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    private static void quickSort(char[] chars, int left, int right) {
        int i, j;
        char mid;
        if (left > right) return;
        mid = chars[left];
        i = left;
        j = right;
        while (i != j) {
            while (i < j && chars[j] >= mid) {
                j--;
            }
            while (i < j && chars[i] <= mid) {
                i++;
            }
            if (i < j) {
                char x = chars[i];
                chars[i] = chars[j];
                chars[j] = x;
            }
        }
        if (left <i-1){
            quickSort(chars,left,i-1);
        }
        if (right>i+1){
            quickSort(chars,i+1,right);
        }
    }
}
