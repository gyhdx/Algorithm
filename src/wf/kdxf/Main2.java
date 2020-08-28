package wf.kdxf;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

//        sort(list, 0, n - 1);
        Arrays.sort(list);

        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");;
        }
    }

    private static void sort(int[] list, int start, int end) {
        if (start >= end)return;
        int mid = (start + end)/2 + 1;
        int i = start;
        int j = end;
        while (i < j){
            while ((i < j) && list[i] < list[mid]){
                i++;
            }
            while ((i < j) &&list[j] > list[mid]){
                j--;
            }
            if (i < j){
                int m = list[i];
                list[i] = list[j];
                list[j] = m;
            }
        }
        sort(list, start, mid - 1);
        sort(list, mid + 1, end);


    }
}
