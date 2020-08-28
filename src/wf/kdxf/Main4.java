package wf.kdxf;

import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int n = sc.nextInt();
        String res = "";

        if (n < str.length()){
            String substring = str.substring(0, n);
            String substring2 = str.substring(n, str.length());
            res = substring2 + substring;
        }else if (n > str.length()){
            n = n % str.length();
            String substring = str.substring(0, n);
            String substring2 = str.substring(n, str.length());
            res = substring2 + substring;
        }else {
            res = str;
        }
        System.out.println(res);
    }
}
