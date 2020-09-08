package wf.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_电话号码的字母组合 {
    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println(list);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0)return list;
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        getStr(digits, 0, "", list, map);

        return list;
    }

    private static void getStr(String digits, int i, String ens, List<String> list, Map<Character, String> map) {
        if (i == digits.length()){
            list.add(ens);
            return;
        }
        String s = map.get(digits.charAt(i));
        for (int j = 0; j < s.length(); j++) {
            getStr(digits, i+1, ens + s.charAt(j), list, map);
        }
    }
}
