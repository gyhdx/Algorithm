package 秋招.网易互娱;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main1 {

    public static void main(String[] args)  {
        int[][] time = {{2020100106, 2020100112}, {2020100108, 2020100115}, {2020100112, 2020100118}};
        boolean[] booleans = adBooking(time);
        for (boolean aBoolean : booleans) {
            System.out.println(aBoolean);
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 批量广告投放预订
     * @param time int整型二维数组 预订时间列表
     * @return bool布尔型一维数组
     */
    public static boolean[] adBooking (int[][] time)  {
        // write code here
        boolean[] ens = new boolean[time.length];
        Map<Date, Date> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            boolean mid = false;
            try {
                mid = booking(map,time[i][0],time[i][1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ens[i] = mid;
        }
        return ens;
    }

    private static boolean booking(Map<Date, Date> map, int start, int end) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
        Date first = format.parse(String.valueOf(start));
        Date last = format.parse(String.valueOf(end));
        if (map.isEmpty()){
            map.put(first,last);
            return true;
        }
        boolean falg = true;
        List<Date> list = new ArrayList<>(map.keySet());
        for (Date date : list) {
            Date s = date;
            Date e = map.get(date);
            if (!(s.equals(last)||s.after(last)||e.equals(first)||e.before(first))){
                falg = false;
            }
        }
        if (falg){
            map.put(first,last);
            return true;
        }
        return false;
    }
}
