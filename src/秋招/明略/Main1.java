package 秋招.明略;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] mid = s.split(" ");
        String ens = mid[mid.length - 1];
        for (int i = mid.length - 2; i >= 0; i--) {
            ens = ens+" "+mid[i];
        }
        System.out.println(ens);
    }
}
