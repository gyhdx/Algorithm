package 秋招.神策;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String end = "";

        String[] list = str.split(" ");
        for (String s : list) {
            if (s.length() > 0) {
                String res = "";
                char[] chars = s.toCharArray();
                for (char aChar : chars) {
                    res = aChar + res;
                }
                end = end + " " + res;
            }
        }

        System.out.println("\"" + end.substring(1, end.length()) + "\"");
    }
}
