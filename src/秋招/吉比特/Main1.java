package 秋招.吉比特;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine();
        String lowerCase = list.toLowerCase();
        String[] split = lowerCase.split(" ");
        String end = split[0];
        char a = split[1].charAt(0);
        char b = split[2].charAt(0);

        char mid = 0;
        int began = -1;
        int lost = -1;
        for (int i = 0; i < end.length(); i++) {
            if (began < 0 && (end.charAt(i) == a || end.charAt(i) == b)){
                began = i;
                mid = end.charAt(i);
            }else if (mid != end.charAt(i) && (end.charAt(i) == a || end.charAt(i) == b)){
                lost = i;
            }
        }
        if (began > -1 && lost > -1){
            System.out.println(lost - began);
        }else {
            System.out.println(-1);
        }

    }
}
