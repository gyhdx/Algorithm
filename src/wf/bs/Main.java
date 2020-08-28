package wf.bs;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            count += search(a[i]);
        }
        System.out.println(count);
    }

    public static int search(int m){
        if (m == 2 || m == 3)return 1;
        if (m >= 4)return m/2;
        else return 0;
    }
}
