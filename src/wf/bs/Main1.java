package wf.bs;

import java.util.ArrayList;
import java.util.Scanner;



public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> t = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            if (x < min)min = x;
            t.add(x);
        }

        if (n == m)print(t);

        int count = 1;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (t.contains(count)){
                count++;
            }
            if (j <= (m - 1) &&count > t.get(j)){
                res.add(t.get(j));
                j++;
            }else {
                res.add(count);
                count++;
            }
        }

        print(res);
//        System.out.println(n + "   " + m);
    }

    public static void print(ArrayList<Integer> list){
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
