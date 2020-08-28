package 秋招.VIPkid;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String s = null;
        while (!(s = sc.nextLine()).equals("")){
            list.add(s);
        }
        int length = list.size();

        int mid[] = new int[length];

        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        for (String str : list) {
            String[] s1 = str.split(" ");
            mid[i++] = Integer.valueOf(s1[0]);
            if (map.keySet().contains(Integer.valueOf(s1[0]))){
                int x = Math.max(Integer.valueOf(s1[1]), map.get(Integer.valueOf(s1[0])));
                map.put(Integer.valueOf(s1[0]), x);
            }else {
                map.put(Integer.valueOf(s1[0]), Integer.valueOf(s1[1]));
            }

        }

        Arrays.sort(mid);

        List<Integer> res = new ArrayList<>();

        for (i = 0; i < length-1; i++) {
            if (map.get(mid[i]) >= mid[i+1]){
                Integer integer = Math.max(map.get(mid[i + 1]), map.get(mid[i]));
                map.remove(mid[i]);
                map.remove(mid[i+1]);
                mid[i + 1] = mid[i];
                map.put(mid[i + 1], integer);
                if (!res.contains(mid[i + 1])){
                    res.add(mid[i + 1]);
                }
            }else {
                res.add(mid[i]);
            }
        }

        System.out.println(" =========== ");

        Set<Integer> integers = map.keySet();
        int setlength = integers.size();
        int setlist[] = new int[setlength];
        i = 0;
        for (Integer integer : integers) {
            setlist[i++] = integer;
        }
        Arrays.sort(setlist);

        for (int integer : setlist) {
            System.out.println(integer + " " + map.get(integer));
        }

//        for (Integer integer : res) {
//            System.out.println(integer + " " + map.get(integer));
//        }
    }
}
