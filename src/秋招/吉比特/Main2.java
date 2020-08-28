package 秋招.吉比特;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextInt();
        long y = sc.nextInt();
        long z = sc.nextInt();
        long N = sc.nextInt();

        int xa = sc.nextInt();
        int ya = sc.nextInt();
        int xb = sc.nextInt();
        int yb = sc.nextInt();
        int xc = sc.nextInt();
        int yc = sc.nextInt();

        for (int i = 0; i < N; i++) {
            long a = x,b = y,c = z;
            x = a + xb*b + xc*c;
            y = b + xa*a + yc*c;
            z = c + ya*a + yb*b;
        }

        System.out.println(x%1000000007 + " " + y%1000000007 + " " + z%1000000007);
    }

}
