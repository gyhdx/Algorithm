package test;

import java.text.ParseException;
import java.util.ArrayList;

public class t1 {

    public static void main(String[] args) throws ParseException {
//        t1 t = new t1();
//        t.fun(null);
//        String a = "1111111111111111111111111111111111111111111";
//        System.out.println(Integer.valueOf(a));
//
//        System.out.println('c');
//        HashMap map = new HashMap();
//        System.out.println(1>>>1);
//        Object o = new Object();

//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
//        int a = 2020100106;
//        System.out.println(format.parse(String.valueOf(a)).toString());
//        ReentrantLock
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(1,2);
        for (int i = 0; i < list.size(); i++) {
            if (i==2){
                list.add(3,4);
            }
        }
        String s = new String();
        StringBuilder builder = new StringBuilder();
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println(list);

    }

    public void fun(Object o){
        System.out.println(o + "o");
    }

    public void fun(t1 t){
        System.out.println(t + "ti");
    }
}
