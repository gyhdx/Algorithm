package 秋招.神策;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 2);
        map.put(2, 5);
        map.put(3, 10);
        map.put(4, 20);
        map.put(5, 50);
        map.put(6, 100);

        int[] list = new int[7];
        for (int i = 0; i < list.length; i++) {
            list[i] = sc.nextInt();
        }

        int money = sc.nextInt();

        int [] rest = new int[7];
        int cas = Integer.MIN_VALUE;

        while (cas >= money){
            for (int i = 6; i >= 0 ; i--) {
                if (list[i] != 0){

                }
            }
        }


//        for (int i = 0; i < list.length; i++) {
//            System.out.print(list[i] + " ");
//        }


    }
}
