package test;

import java.util.ArrayList;
import java.util.List;

public class Test {

    /*
    101-200之间的素数
     */
    public static void main(String[] args) {
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 101; i < 201; i++) {
            if (pd(i)){
                count++;
                list.add(i);
            }
        }
        System.out.println(count);
        System.out.println(list);
    }

    private static boolean pd(int n) {

        for (int j = 2; j < Math.sqrt(n); j++) {
            if (n%j == 0){
                return false;
            }
        }
        return true;
    }
}
