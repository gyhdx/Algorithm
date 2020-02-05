package wf.jianzhi_offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */

public class 字符串的排列 {
    public static void main(String[] args) {
        String str = "abbc";
        ArrayList<String> permutation = Permutation(str);
        System.out.println(permutation);
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null) return list;
        sf(str.toCharArray(),0,list);
        java.util.Collections.sort(list);
        return list;
    }

    private static void sf(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length-1){
            String s = new String(chars);
            if (!list.contains(s)){
                list.add(s);
            }
        }else {
            for (int j=i;j<chars.length;j++){
                swap(i,j,chars);
                sf(chars,i+1,list);
                swap(i,j,chars);
            }
        }
    }

    private static void swap(int i, int j, char[] chars) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
