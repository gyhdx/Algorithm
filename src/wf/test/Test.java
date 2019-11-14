package wf.test;

import java.util.ArrayList;
import java.util.List;

public class Test implements TI1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.sort(Integer::compareTo);

    }


    @Override
    public void f() {
        System.out.println("tews");
    }
}
