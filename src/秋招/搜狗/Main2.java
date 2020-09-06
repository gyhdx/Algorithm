package 秋招.搜狗;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) {
        int[] list = {-1, 3, 5, 4};
        System.out.println(getHouses2(2, list));
    }

    public static int getHouses(int t, int[] xa) {
        // write code here
        if (xa.length == 0) return 1;
        if (xa.length == 2) return 2;

        int couunt = 2;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < xa.length; i+=2) {
            map.put(xa[i], xa[i+1]);
        }

        Set<Integer> local = map.keySet();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (Integer integer : local) {
            arrayList.add(integer);
        }
        Collections.sort(arrayList);

        for (int i = 0; i < arrayList.size() - 1; i++) {
            int area = arrayList.get(i + 1) - map.get(arrayList.get(i + 1))/2 - arrayList.get(i) + map.get(arrayList.get(i))/2;
            if (area > t) {
                couunt += 2;
            } else if (area == t) {
                couunt++;
            }
        }

        return couunt;
    }

    public static int getHouses2(int t, int[] xa) {
        // write code here
        if (xa.length == 0) return 0;
        if (xa.length == 2) return 2;

        int couunt = 2;
        int i = 0, j = 2;
        while (j < xa.length) {
            double area = (xa[j] - xa[j + 1] / 2.0) - (xa[i] + xa[i + 1] / 2.0);
            if (area > t) {
                couunt += 2;
            } else if (area == t) {
                couunt++;
            }
            j += 2;
            i += 2;
        }
        return couunt;
    }

    public static int getHouses3(int t, int[] xa) {
        // write code here
        if (xa.length == 0) return 1;
        if (xa.length == 2) return 2;

        int couunt = 2;
        int i = 0, j = 2;
        while (j < xa.length) {
            int area = xa[j] - xa[j + 1] / 2 - xa[i] + xa[i + 1] / 2;
            if (area > t) {
                couunt += 2;
            } else if (area == t) {
                couunt++;
            }
            j += 2;
            i += 2;
        }
        return couunt;
    }
}
