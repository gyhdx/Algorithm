package wf.bs;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/31 14:03
 */
public class kdxf_字符串中获取数字 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String out = getnumber(input);
        System.out.println(out);
    }

    private static String getnumber(String input) {
        char[] chars = input.toCharArray();
        String num = "";
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                num += aChar;
            }
        }
        return num;
    }
}
