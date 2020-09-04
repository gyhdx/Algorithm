package 秋招._58同城;

import java.util.ArrayList;

public class Main1 {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        ArrayList<String> list = null;
        lists.add(list);
        ArrayList<String> list1 = new ArrayList<>();
        lists.add(list1);
        System.out.println(findCommonString(lists));

    }

    public static ArrayList<String> findCommonString(ArrayList<ArrayList<String>> values) {
        // write code here
        ArrayList<String> list = new ArrayList<>();

        if (values != null && values.get(0) != null) {

            for (String s : values.get(0)) {
                boolean falg = true;
                for (ArrayList<String> value : values) {
                    if (!value.contains(s)) {
                        falg = false;
                    }
                }
                if (falg) {
                    list.add(s);
                }
            }
        }
        return list;
    }
}
