package wf.test;

import java.util.*;

public class Test implements TI1 {

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList();
//        list.sort(Integer::compareTo);
//        Stack<Integer> stack = new Stack<>();
////        stack.push(1);
//        stack.push(null);
////        stack.push(2);
//        System.out.println(stack.empty());
//        String s = "abcd";
//        String[] chars = s.split("");
//        System.out.println(chars[0]);
//
//        ArrayList<String> list = new ArrayList(Arrays.asList(chars));
//        System.out.println(list.isEmpty());
//        System.out.println(list);
//        String s1 = "";
//        System.out.println(s1.length());
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
//        System.out.println(list.get(3));
    }


    @Override
    public void f() {
        System.out.println("tews");
    }
}
