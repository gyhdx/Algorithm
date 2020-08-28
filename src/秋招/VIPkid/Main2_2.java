package 秋招.VIPkid;

import java.util.*;

public class Main2_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String s = null;
        while (!(s = sc.nextLine()).equals("")){
            list.add(s);
        }
        int length = list.size();

        long mid[] = new long[length];

        Map<Long, Long> map = new HashMap<>();

        int i = 0;
        for (String str : list) {
            String[] s1 = str.split(" ");
            mid[i++] = Long.valueOf(s1[0]);
            map.put(Long.valueOf(s1[0]), Long.valueOf(s1[1]));
        }

        Arrays.sort(mid);

        List<Long> res = new ArrayList<>();

        for (i = 0; i < length-1; i++) {
            if (map.get(mid[i]) >= mid[i+1]){
                Long Long = Math.max(map.get(mid[i + 1]), map.get(mid[i]));
                map.remove(mid[i]);
                map.remove(mid[i+1]);
                mid[i + 1] = mid[i];
                map.put(mid[i + 1], Long);
                if (!res.contains(mid[i + 1])){
                    res.add(mid[i + 1]);
                }
            }else {
                res.add(mid[i]);
            }
        }


        Set<Long> Longs = map.keySet();
        int setlength = Longs.size();
        long setlist[] = new long[setlength];
        i = 0;
        for (Long Long : Longs) {
            setlist[i++] = Long;
        }
        Arrays.sort(setlist);

        for (long Long : setlist) {
            System.out.println(Long + " " + map.get(Long));
        }
    }
}
