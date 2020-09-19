package 秋招.瑛太莱;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String substring = line.substring(1, line.length() - 1);
        String[] split = substring.split(",");
        int[] res = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            res[i] = Integer.valueOf(split[i]);
        }
        System.out.println(getMax(res));
    }

    private static int getMax(int[] res) {
        int ens = 0;
        int mid = 0;
        for (int i = 0; i < res.length; i++) {
            if (mid>0){
                mid+=res[i];
            }else {
                mid = res[i];
            }

            ens = Math.max(ens,mid);
        }
        return ens;
    }
}
