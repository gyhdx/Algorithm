package wf.kdxf;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        long count = 0;

        while (n != 0){
            if ((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }

        System.out.println(count);
    }
}
