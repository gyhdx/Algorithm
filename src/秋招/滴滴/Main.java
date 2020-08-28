package 秋招.滴滴;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            int j = 0;
            if (i != j){
                for (; j < 10; j++) {
                    int k = 0;
                    if (i != k && j != k){
                        for (; k < 10; k++) {
                            int abc = i*100+j*10+k;
                            int acc = i*100+k*10+k;
                            if (abc + acc == input){
                                map.put(abc, acc);
                            }
                        }
                    }
                }
            }
        }


        if (map.size() == 0){
            System.out.println(0);
        }else {
            Set<Integer> integers = map.keySet();
            Integer[] integers1 = new Integer[integers.size()];
            int i = 0;
            for (Integer integer : integers) {
                integers1[i] = integer;
                i++;
            }
            Arrays.sort(integers1);
            System.out.println(map.size());
            for (i = 0; i < integers1.length; i++) {
                System.out.println(integers1[i] + " " + map.get(integers1[i]));
            }
        }
    }
}
