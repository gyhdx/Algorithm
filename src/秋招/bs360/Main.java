package 秋招.bs360;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String[] list = new String[m];
        int count = 0;
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            list[i] = sc.nextLine();
        }

        for (int i = 0; i < m; i++) {
            boolean flag = true;
            if (list[i].length() > 10){
                flag = false;
            }else {
                char[] chars = list[i].toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char s = chars[j];
                    if (!((s >= 'a' && s <= 'z') || (s >= 'A' && s <= 'Z'))) {
                        flag = false;
                    }
                }
            }

            if (flag){
                count++;
            }
        }
        System.out.println(count);
    }
}
