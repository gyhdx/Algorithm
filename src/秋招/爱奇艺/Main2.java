package 秋招.爱奇艺;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine();

        Set<String> set = new HashSet<>();

        int i = 0;
        int j = 0;

        char[] chars = list.toCharArray();
        for (char aChar : chars) {
            String end = "";
            end = end + i + j;

            if (set.contains(end)){
                System.out.println("True");
                return;
            }else {
                set.add(end);
            }
            if (aChar == 'N'){
                i--;
            }else if (aChar == 'S'){
                i++;
            }else if (aChar== 'E'){
                j--;
            }else if (aChar== 'W'){
                j++;
            }
        }
        System.out.println("False");
    }
}
