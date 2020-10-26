package test;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;

public class t2  {

    public static void main(String[] args) {
//        Thread t = new Thread();
//        Random random = new Random();
//        System.out.println(random.nextInt(8));
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put(1,1);
        String s = "acasd{{}}cew";
        System.out.println(s.substring(0,s.indexOf("{{")));
        System.out.println(s.substring(s.indexOf("{{")+2,s.indexOf("}}")).length());
        System.out.println(s.substring(s.indexOf("}}")+2));
        LinkedHashSet set = new LinkedHashSet();
        Iterator iterator = set.iterator();

    }
}
