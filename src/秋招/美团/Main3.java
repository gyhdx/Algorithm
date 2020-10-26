package 秋招.美团;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0,0);
            map.put(1,0);
            map.put(2,0);
            int t = Integer.valueOf(sc.nextLine());
            String l = sc.nextLine();
            int[] people = new int[t];
            char[] chars = l.toCharArray();
            for (int j = 0; j < t; j++) {
                int mid = chars[j] - '0';
                people[j] = mid;
                map.put(mid, map.get((Integer)mid) + 1);
            }
            int m = Integer.valueOf(sc.nextLine());
            String man = sc.nextLine();
            char[] array = man.toCharArray();
            for (char c : array) {
                if (c == 'M'){
                    if (map.get((Integer)1) == 0){
                        for (int j = 0; j < t; j++) {
                            if (people[j] == 0){
                                System.out.println(j+1);
                                people[j] = 1;
                                map.put(1, 1);
                                map.put(0, map.get((Integer)0) - 1);
                                break;
                            }
                        }
                    }else {
                        for (int j = 0; j < t; j++) {
                            if (people[j] == 1){
                                System.out.println(j+1);
                                people[j] = 2;
                                map.put(2, map.get((Integer)2) + 1);
                                map.put(1, map.get((Integer)1) - 1);
                                break;
                            }
                        }
                    }
                }else if (c == 'F'){
                    if (map.get((Integer)0) == 0){
                        for (int j = 0; j < t; j++) {
                            if (people[j] == 1){
                                System.out.println(j+1);
                                people[j] = 2;
                                map.put(2, map.get((Integer)2) + 1);
                                map.put(1, map.get((Integer)1) - 1);
                                break;
                            }
                        }
                    }else {
                        for (int j = 0; j < t; j++) {
                            if (people[j] == 0){
                                System.out.println(j+1);
                                people[j] = 1;
                                map.put(0, map.get((Integer)0) - 1);
                                map.put(1, map.get((Integer)1) + 1);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
