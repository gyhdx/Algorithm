package wf.test;

import wf.cacshAlg.Cache;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        int[][] a = new int[9][3];
        System.out.println(a.length);
        System.out.println(a[0].length);

        String c = "vsd";
        String b = c + " ";
        System.out.println(b+"-");
        Cache.displayMenu();
        Scanner sc = new Scanner(System.in);
        int aa=sc.nextInt();
        while (true){
            if (aa==12){
                break;
            }
            aa=sc.nextInt();
        }

        System.out.println(aa);
    }
}
