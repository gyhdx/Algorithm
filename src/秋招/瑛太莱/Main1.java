package 秋招.瑛太莱;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine();
        String[] split = list.split(" ");
        if (split.length < 2) {
            System.out.println(0);
            return;
        }
        String hay = split[0];
        String needle = split[1];
        int index = hay.indexOf(needle);
        System.out.println(index);
    }
}
